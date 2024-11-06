package ro.devcon.ai.workshop.common.domain.repository;

import ro.devcon.ai.workshop.common.domain.entity.Embedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmbeddingRepository extends JpaRepository<Embedding, Long> {
    @Query(value = """
        SELECT e.* FROM embeddings e
        WHERE e.embedding <-> (:queryEmbedding)::vector <= 0.4
        LIMIT :limit
        """, nativeQuery = true)
    List<Embedding> findMostSimilar(float[] queryEmbedding, int limit);
}