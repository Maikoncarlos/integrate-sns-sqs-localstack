## Integrate Spring Boot application with AWS SNS/SQS using Localstack

### Reference links:
https://aws.amazon.com/sns/

https://aws.amazon.com/sqs/

https://docs.aws.amazon.com/sns/lates

https://docs.localstack.cloud/overview/

https://spring.io/projects/spring-clo

https://awspring.io/

https://docs.aws.amazon.com/sns/lates


### Comandos docker:
- subir uma imagem da localstack via docker-compose.yml: $docker-compose up -d
- extrar dentro do executável bash da imagem localstack: $docker exec -it idContainer bash
- remover imagem localstack: $docker rm idContainer --force

### Comandos localstack: 
- sair de dentro do Container: $exit

doc-localstack-sns: https://docs.localstack.cloud/user-guide/aws/sns/
- criar topico sns: $ awslocal sns create-topic --name localstack-topic
- listar topicos sns: $ awslocal sns list-topics
- deletar topico sns: $ awslocal sns delete-topic --topic-arn hostTopicoCriado
- modelo de topic sns: "TopicArn": "arn:aws:sns:us-east-1:000000000000:localstack-topic"


doc-localstack-sqs: https://docs.localstack.cloud/user-guide/aws/sqs/
- criar fila sqs: $ awslocal sqs create-queue --queue-name localstack-queue
- listar filas sqq: $ awslocal sqs list-queue
- deletar fila sqs: $a wslocal sqs delete-queue --queue-url QueueUrlCriada
- modelo de fila sqs: "QueueUrl": "http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/localstack-queue"


#### --> Instruções para criação de ambinete local no arquivo localstack.txt

### Se quiser ver a Interface Gráfica da LocalStack
https://app.localstack.cloud/sign-in
- fazer o login, de preferência com a sua conta do GitHub;
- ir no menu esquerdo em 'Default Instance' e clicar no Serviço de SNS e SQS ou em outro que queira ver;