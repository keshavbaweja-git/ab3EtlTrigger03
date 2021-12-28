package schema.aws.s3.objectcreated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import java.io.Serializable;

public class Object implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("etag")
  private String etag = null;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("sequencer")
  private String sequencer = null;

  @JsonProperty("size")
  private BigDecimal size = null;

  @JsonProperty("version-id")
  private String versionId = null;

  public Object etag(String etag) {
    this.etag = etag;
    return this;
  }
  

  public String getEtag() {
    return etag;
  }

  public void setEtag(String etag) {
    this.etag = etag;
  }

  public Object key(String key) {
    this.key = key;
    return this;
  }
  

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Object sequencer(String sequencer) {
    this.sequencer = sequencer;
    return this;
  }
  

  public String getSequencer() {
    return sequencer;
  }

  public void setSequencer(String sequencer) {
    this.sequencer = sequencer;
  }

  public Object size(BigDecimal size) {
    this.size = size;
    return this;
  }
  

  public BigDecimal getSize() {
    return size;
  }

  public void setSize(BigDecimal size) {
    this.size = size;
  }

  public Object versionId(String versionId) {
    this.versionId = versionId;
    return this;
  }
  

  public String getVersionId() {
    return versionId;
  }

  public void setVersionId(String versionId) {
    this.versionId = versionId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Object object = (Object) o;
    return Objects.equals(this.etag, object.etag) &&
        Objects.equals(this.key, object.key) &&
        Objects.equals(this.sequencer, object.sequencer) &&
        Objects.equals(this.size, object.size) &&
        Objects.equals(this.versionId, object.versionId);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(etag, key, sequencer, size, versionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Object {\n");
    
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    sequencer: ").append(toIndentedString(sequencer)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
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
