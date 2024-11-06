package ro.devcon.ai.workshop.common.service;

import ro.devcon.ai.workshop.common.domain.entity.Embedding;
import ro.devcon.ai.workshop.common.domain.repository.EmbeddingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VectorService {
    private final EmbeddingModel embeddingModel;
    private final EmbeddingRepository embeddingRepository;

    @Transactional
    public void storeEmbedding(String content) {
        float[] embeddings = embeddingModel.embed(content);

        Embedding entity = createEntity(content, embeddings);

        embeddingRepository.save(entity);
    }

    private Embedding createEntity(String content, float[] embeddings) {
        return Embedding.builder()
                        .content(content)
                        .embedding(embeddings)
                        .createdAt(LocalDateTime.now())
                        .build();
    }

    public List<String> findSimilar(String query, int limit) {
        float[] embeddings = embeddingModel.embed(query);
        return embeddingRepository.findMostSimilar(embeddings, limit)
                                  .stream()
                                  .map(Embedding::getContent)
                                  .collect(Collectors.toList());
    }
}
