# 02-prompt-with-template

Demonstrates using simple templates to structure prompts consistently.

## Key Concepts
- String templates
- Parameter substitution
- Formatted prompts

## Example Usage
```java
PromptTemplate promptTemplate = new PromptTemplate("Tell us a {adjective} joke about {topic}");
Prompt prompt = promptTemplate.create(Map.of());
String response = chatClient.prompt(prompt)
                            .call()
                            .content();
```