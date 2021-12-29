package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import schema.aws.s3.objectcreated.AWSEvent;
import schema.aws.s3.objectcreated.ObjectCreated;
import schema.aws.s3.objectcreated.marshaller.Marshaller;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
import software.amazon.awssdk.services.glue.GlueAsyncClient;
import software.amazon.awssdk.services.glue.model.StartJobRunRequest;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Handler for EventBridge invocations of a Lambda function target
 */
public class App implements RequestStreamHandler {

    private static final SdkAsyncHttpClient sdkAsyncHttpClient = AwsCrtAsyncHttpClient.create();

    private static final GlueAsyncClient glueClient = GlueAsyncClient.builder()
                                                           .httpClient(sdkAsyncHttpClient)
                                                           .build();

    private Object handleEvent(final AWSEvent<ObjectCreated> inputEvent, final Context context) {
        if (inputEvent == null) {
            return inputEvent;
        }

        ObjectCreated objectCreated = inputEvent.getDetail();

        if (objectCreated.getBucket() == null) {
            log("S3 Bucket is null");
            return inputEvent;
        }
        log(String.format("Bucket Name:%s",
                          objectCreated.getBucket()
                                       .getName()));


        if (objectCreated.getObject() == null) {
            log("S3 Object is null");
            return inputEvent;
        }
        log(String.format("Object Key:%s",
                          objectCreated.getObject()
                                       .getKey()));


        final String ab03GlueTransformationJobName = System.getenv("AB03_GLUE_TRANSFORMATION_JOB");
        log(String.format("AB03_GLUE_TRANSFORMATION_JOB:%s",
                          ab03GlueTransformationJobName));

        glueClient.startJobRun(StartJobRunRequest.builder()
                                                 .jobName(ab03GlueTransformationJobName)
                                                 .build());

        log(String.format("Started glue job:%s",
                          ab03GlueTransformationJobName));

        return inputEvent;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input stream
     * @param output  The Lambda function output stream
     * @param context The Lambda execution environment context object.
     * @throws IOException
     */
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        input.transferTo(baos);
        log(String.format("input: %s",
                          baos.toString(UTF_8)));

        AWSEvent<ObjectCreated> event = Marshaller.unmarshalEvent(new ByteArrayInputStream(baos.toByteArray()),
                                                                  ObjectCreated.class);
        Object response = handleEvent(event,
                                      context);
        Marshaller.marshal(output,
                           response);
    }

    public void log(String s) {
        System.out.println(s);
    }
}
