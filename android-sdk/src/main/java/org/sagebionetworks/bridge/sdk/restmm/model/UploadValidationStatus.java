package org.sagebionetworks.bridge.sdk.restmm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class UploadValidationStatus {
  private final String id;
  private final List<String> messageList;
  private final UploadStatus status;

  /**
   * Private constructor. All construction should go through the builder.
   */
  private UploadValidationStatus(String id, List<String> messageList, UploadStatus status) {
    this.id = id;
    this.messageList = messageList;
    this.status = status;
  }

  /**
   * Unique upload ID, as generated by the request upload API. Always non-null and non-empty.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * <p> List of validation messages, generally contains error messages. Since a single upload file
   * may fail validation in multiple ways, Bridge server will attempt to return all messages to the
   * user. For example, the upload file might be unencrypted, uncompressed, and it might not fit
   * any
   * of the expected schemas for the study. </p> <p> This field is always non-null, but it may be
   * empty. The list is immutable and contains non-null, non-empty strings. </p>
   *
   * @return messageList
   */
  public List<String> getMessageList() {
    return messageList;
  }

  /**
   * Represents upload status, such as requested, validation in progress, validation failed, or
   * succeeded. Always non-null.
   *
   * @return uploadStatus
   */
  public UploadStatus getStatus() {
    return status;
  }

  /**
   * Represents the lifecycle of an upload object.
   */
  public enum UploadStatus {
    /**
     * Upload status is unknown.
     */
    @SerializedName("unknown")
    UNKNOWN,

    /**
     * Initial state. Upload is requested. User needs to upload to specified URL and call
     * uploadComplete.
     */
    @SerializedName("requested")
    REQUESTED,

    /**
     * User has called uploadComplete. Upload validation is currently taking place.
     */
    @SerializedName("validation_in_progress")
    VALIDATION_IN_PROGRESS,

    /**
     * Upload validation has failed.
     */
    @SerializedName("validation_failed")
    VALIDATION_FAILED,

    /**
     * Upload has succeeded, including validation.
     */
    @SerializedName("succeeded")
    SUCCEEDED
  }
}