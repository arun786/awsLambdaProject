package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.InputRequest;
import model.OutputRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Job implements RequestHandler<List<InputRequest>, Map<String, OutputRequest>> {
    @Override
    public Map<String, OutputRequest> handleRequest(List<InputRequest> inputRequests, Context context) {

        Map<String, OutputRequest> response = new HashMap<>();
        inputRequests.forEach(inputRequest -> {
            OutputRequest outputRequest = new OutputRequest();
            outputRequest.setName(inputRequest.getName());
            Integer age = inputRequest.getAge();
            outputRequest.setAge(age);
            outputRequest.setAdult(age > 18);
            String key = inputRequest.getId();
            response.put(key, outputRequest);
        });

        return response;
    }
}
