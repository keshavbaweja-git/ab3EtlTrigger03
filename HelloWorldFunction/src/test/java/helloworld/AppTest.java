package helloworld;

import org.junit.Test;
import schema.aws.s3.objectcreated.AWSEvent;
import schema.aws.s3.objectcreated.ObjectCreated;
import schema.aws.s3.objectcreated.marshaller.Marshaller;

import java.io.*;

public class AppTest {
    @Test
    public void successfulResponse() throws IOException {
        App app = new App();

        ObjectCreated detail = new ObjectCreated();

        AWSEvent<ObjectCreated> event =
                new AWSEvent<ObjectCreated>()
                        .detail(detail);

        InputStream handlerInput = toInputStream(event);
        OutputStream handlerOutput = testStringOutputStream();

        app.handleRequest(handlerInput,
                          handlerOutput,
                          null);
    }

    private InputStream toInputStream(AWSEvent event) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Marshaller.marshal(output,
                           event);

        return new ByteArrayInputStream(output.toByteArray());
    }

    private OutputStream testStringOutputStream() {
        return new OutputStream() {
            private StringBuilder string = new StringBuilder();

            @Override
            public void write(int x) throws IOException {
                this.string.append((char) x);
            }

            public String toString() {
                return this.string.toString();
            }
        };
    }
}

