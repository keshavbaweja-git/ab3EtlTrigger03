package schema.aws.s3.objectcreated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import schema.aws.s3.objectcreated.Bucket;
import java.io.Serializable;

public class ObjectCreated implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("bucket")
  private Bucket bucket = null;

  @JsonProperty("object")
  private Object object = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("request-id")
  private String requestId = null;

  @JsonProperty("requester")
  private String requester = null;

  @JsonProperty("source-ip-address")
  private String sourceIpAddress = null;

  @JsonProperty("version")
  private String version = null;

  public ObjectCreated bucket(Bucket bucket) {
    this.bucket = bucket;
    return this;
  }
  

  public Bucket getBucket() {
    return bucket;
  }

  public void setBucket(Bucket bucket) {
    this.bucket = bucket;
  }

  public ObjectCreated object(Object object) {
    this.object = object;
    return this;
  }
  

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

  public ObjectCreated reason(String reason) {
    this.reason = reason;
    return this;
  }
  

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ObjectCreated requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }
  

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public ObjectCreated requester(String requester) {
    this.requester = requester;
    return this;
  }
  

  public String getRequester() {
    return requester;
  }

  public void setRequester(String requester) {
    this.requester = requester;
  }

  public ObjectCreated sourceIpAddress(String sourceIpAddress) {
    this.sourceIpAddress = sourceIpAddress;
    return this;
  }
  

  public String getSourceIpAddress() {
    return sourceIpAddress;
  }

  public void setSourceIpAddress(String sourceIpAddress) {
    this.sourceIpAddress = sourceIpAddress;
  }

  public ObjectCreated version(String version) {
    this.version = version;
    return this;
  }
  

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectCreated objectCreated = (ObjectCreated) o;
    return Objects.equals(this.bucket, objectCreated.bucket) &&
        Objects.equals(this.object, objectCreated.object) &&
        Objects.equals(this.reason, objectCreated.reason) &&
        Objects.equals(this.requestId, objectCreated.requestId) &&
        Objects.equals(this.requester, objectCreated.requester) &&
        Objects.equals(this.sourceIpAddress, objectCreated.sourceIpAddress) &&
        Objects.equals(this.version, objectCreated.version);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(bucket, object, reason, requestId, requester, sourceIpAddress, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectCreated {\n");
    
    sb.append("    bucket: ").append(toIndentedString(bucket)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    requester: ").append(toIndentedString(requester)).append("\n");
    sb.append("    sourceIpAddress: ").append(toIndentedString(sourceIpAddress)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
