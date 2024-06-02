package github.maikoncarlos.integrate.sns.sqs.localstack.controller;

import github.maikoncarlos.integrate.sns.sqs.localstack.model.User;
import io.awspring.cloud.sns.core.SnsNotification;
import io.awspring.cloud.sns.core.SnsTemplate;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SnsTemplate snsTemplate;

    public UserController(SnsTemplate snsTemplate) {
        this.snsTemplate = snsTemplate;
    }

    @PostMapping(value = "/publishSNSNotification")
    public ResponseEntity<String> publishSNSNotification(@RequestBody User user) {
        logger.info("Starting publication on SNS topic 'my-topic', content: {} ", user);
        snsTemplate.sendNotification("my-topic", SnsNotification.of(user));
        return ResponseEntity.ok(user.toString());
    }

    @SqsListener(value = "my-queue")
    public ResponseEntity<User> listenerSQS(User user){
        logger.info("Message received on SQS queue 'my-queue', result: {} ", user);
        return ResponseEntity.ok(user);
    }

}
