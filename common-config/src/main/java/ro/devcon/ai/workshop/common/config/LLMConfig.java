package ro.devcon.ai.workshop.common.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Value("${OPEN-AI.API-KEY}")
    private String openAiApiKey;

    @Bean
    public OpenAiChatModel openAIChatLanguageModel() {
        return new OpenAiChatModel(new OpenAiApi(openAiApiKey));
    }

    @Bean
    public ChatClient openAIChatClient() {
        return ChatClient.builder(openAIChatLanguageModel())
                         .build();
    }
}
