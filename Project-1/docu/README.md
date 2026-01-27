
# DocuAI

DocuAI is an intelligent agent designed to answer questions based on a given set of documents. It uses a Retrieval-Augmented Generation (RAG) model to provide accurate answers with citations from the source documents.

## Features

*   **Q&A:** Ask questions in natural language.
*   **Citations:** Get answers with citations, including the document ID and a snippet of the relevant text.
*   **REST API:** Easy to integrate with other applications through a simple REST API.
*   **Ticket Creation:** Option to create a ticket if the answer is not satisfactory.

## Technology Stack

*   **Java:** The core application is built using Java.
*   **Spring Boot:** Framework for creating stand-alone, production-grade Spring based Applications.
*   **Maven:** Dependency management and build automation.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 17 or later.
*   Apache Maven.

### Building the Project

1.  Clone the repository:
    ```sh
    git clone <repository-url>
    ```
2.  Navigate to the project directory:
    ```sh
    cd docu
    ```
3.  Build the project using Maven:
    ```sh
    ./mvnw clean install
    ```

### Running the Application

You can run the application using the following command:

```sh
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Usage

The main endpoint for interacting with the agent is `/api/agent/ask`.

### Request

Send a `POST` request to `/api/agent/ask` with the following JSON payload:

```json
{
  "question": "What is the capital of France?",
  "createTicket": false
}
```

*   `question` (string, required): The question you want to ask the agent.
*   `createTicket` (boolean, optional): Set to `true` if you want to create a ticket.

### Response

The API will respond with a JSON object containing the answer and citations:

```json
{
  "answer": "The capital of France is Paris.",
  "citations": [
    {
      "docId": "doc123",
      "snippet": "Paris is the capital and most populous city of France..."
    }
  ],
  "shouldCreateTicket": false
}
```

*   `answer` (string): The agent's answer to the question.
*   `citations` (array): A list of citations supporting the answer.
    *   `docId` (string): The ID of the source document.
    *   `snippet` (string): A snippet of text from the source document.
*   `shouldCreateTicket` (boolean): Indicates if a ticket should be created.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or create an issue.

## License

This project is licensed under the MIT License.
