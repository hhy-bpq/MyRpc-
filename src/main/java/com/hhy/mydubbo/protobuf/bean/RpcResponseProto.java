// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RpcResponse.proto

package com.hhy.mydubbo.protobuf.bean;

public final class RpcResponseProto {
  private RpcResponseProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RpcResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:netty.RpcResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 ID = 1;</code>
     */
    long getID();

    /**
     * <code>optional string errorMsg = 2;</code>
     */
    String getErrorMsg();
    /**
     * <code>optional string errorMsg = 2;</code>
     */
    com.google.protobuf.ByteString
        getErrorMsgBytes();

    /**
     * <code>optional string result = 3;</code>
     */
    String getResult();
    /**
     * <code>optional string result = 3;</code>
     */
    com.google.protobuf.ByteString
        getResultBytes();

    /**
     * <code>optional bool event = 4;</code>
     */
    boolean getEvent();

    /**
     * <code>optional string resultType = 5;</code>
     */
    String getResultType();
    /**
     * <code>optional string resultType = 5;</code>
     */
    com.google.protobuf.ByteString
        getResultTypeBytes();
  }
  /**
   * Protobuf type {@code netty.RpcResponse}
   */
  public  static final class RpcResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:netty.RpcResponse)
      RpcResponseOrBuilder {
    // Use RpcResponse.newBuilder() to construct.
    private RpcResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RpcResponse() {
      iD_ = 0L;
      errorMsg_ = "";
      result_ = "";
      event_ = false;
      resultType_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private RpcResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              iD_ = input.readInt64();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              errorMsg_ = s;
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              result_ = s;
              break;
            }
            case 32: {

              event_ = input.readBool();
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();

              resultType_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return RpcResponseProto.internal_static_netty_RpcResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RpcResponseProto.internal_static_netty_RpcResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RpcResponse.class, Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private long iD_;
    /**
     * <code>optional int64 ID = 1;</code>
     */
    public long getID() {
      return iD_;
    }

    public static final int ERRORMSG_FIELD_NUMBER = 2;
    private volatile Object errorMsg_;
    /**
     * <code>optional string errorMsg = 2;</code>
     */
    public String getErrorMsg() {
      Object ref = errorMsg_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        errorMsg_ = s;
        return s;
      }
    }
    /**
     * <code>optional string errorMsg = 2;</code>
     */
    public com.google.protobuf.ByteString
        getErrorMsgBytes() {
      Object ref = errorMsg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        errorMsg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int RESULT_FIELD_NUMBER = 3;
    private volatile Object result_;
    /**
     * <code>optional string result = 3;</code>
     */
    public String getResult() {
      Object ref = result_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        result_ = s;
        return s;
      }
    }
    /**
     * <code>optional string result = 3;</code>
     */
    public com.google.protobuf.ByteString
        getResultBytes() {
      Object ref = result_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        result_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int EVENT_FIELD_NUMBER = 4;
    private boolean event_;
    /**
     * <code>optional bool event = 4;</code>
     */
    public boolean getEvent() {
      return event_;
    }

    public static final int RESULTTYPE_FIELD_NUMBER = 5;
    private volatile Object resultType_;
    /**
     * <code>optional string resultType = 5;</code>
     */
    public String getResultType() {
      Object ref = resultType_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        resultType_ = s;
        return s;
      }
    }
    /**
     * <code>optional string resultType = 5;</code>
     */
    public com.google.protobuf.ByteString
        getResultTypeBytes() {
      Object ref = resultType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        resultType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (iD_ != 0L) {
        output.writeInt64(1, iD_);
      }
      if (!getErrorMsgBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, errorMsg_);
      }
      if (!getResultBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, result_);
      }
      if (event_ != false) {
        output.writeBool(4, event_);
      }
      if (!getResultTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, resultType_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (iD_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, iD_);
      }
      if (!getErrorMsgBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, errorMsg_);
      }
      if (!getResultBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, result_);
      }
      if (event_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(4, event_);
      }
      if (!getResultTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, resultType_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof RpcResponse)) {
        return super.equals(obj);
      }
      RpcResponse other = (RpcResponse) obj;

      boolean result = true;
      result = result && (getID()
          == other.getID());
      result = result && getErrorMsg()
          .equals(other.getErrorMsg());
      result = result && getResult()
          .equals(other.getResult());
      result = result && (getEvent()
          == other.getEvent());
      result = result && getResultType()
          .equals(other.getResultType());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getID());
      hash = (37 * hash) + ERRORMSG_FIELD_NUMBER;
      hash = (53 * hash) + getErrorMsg().hashCode();
      hash = (37 * hash) + RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getResult().hashCode();
      hash = (37 * hash) + EVENT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getEvent());
      hash = (37 * hash) + RESULTTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getResultType().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static RpcResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RpcResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RpcResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RpcResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RpcResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static RpcResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static RpcResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static RpcResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static RpcResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static RpcResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(RpcResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code netty.RpcResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:netty.RpcResponse)
        RpcResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RpcResponseProto.internal_static_netty_RpcResponse_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RpcResponseProto.internal_static_netty_RpcResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                RpcResponse.class, Builder.class);
      }

      // Construct using com.hhy.mydubbo.protobuf.bean.RpcResponseProto.RpcResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        iD_ = 0L;

        errorMsg_ = "";

        result_ = "";

        event_ = false;

        resultType_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RpcResponseProto.internal_static_netty_RpcResponse_descriptor;
      }

      public RpcResponse getDefaultInstanceForType() {
        return RpcResponse.getDefaultInstance();
      }

      public RpcResponse build() {
        RpcResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public RpcResponse buildPartial() {
        RpcResponse result = new RpcResponse(this);
        result.iD_ = iD_;
        result.errorMsg_ = errorMsg_;
        result.result_ = result_;
        result.event_ = event_;
        result.resultType_ = resultType_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof RpcResponse) {
          return mergeFrom((RpcResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(RpcResponse other) {
        if (other == RpcResponse.getDefaultInstance()) return this;
        if (other.getID() != 0L) {
          setID(other.getID());
        }
        if (!other.getErrorMsg().isEmpty()) {
          errorMsg_ = other.errorMsg_;
          onChanged();
        }
        if (!other.getResult().isEmpty()) {
          result_ = other.result_;
          onChanged();
        }
        if (other.getEvent() != false) {
          setEvent(other.getEvent());
        }
        if (!other.getResultType().isEmpty()) {
          resultType_ = other.resultType_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        RpcResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (RpcResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long iD_ ;
      /**
       * <code>optional int64 ID = 1;</code>
       */
      public long getID() {
        return iD_;
      }
      /**
       * <code>optional int64 ID = 1;</code>
       */
      public Builder setID(long value) {
        
        iD_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 ID = 1;</code>
       */
      public Builder clearID() {
        
        iD_ = 0L;
        onChanged();
        return this;
      }

      private Object errorMsg_ = "";
      /**
       * <code>optional string errorMsg = 2;</code>
       */
      public String getErrorMsg() {
        Object ref = errorMsg_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          errorMsg_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string errorMsg = 2;</code>
       */
      public com.google.protobuf.ByteString
          getErrorMsgBytes() {
        Object ref = errorMsg_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          errorMsg_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string errorMsg = 2;</code>
       */
      public Builder setErrorMsg(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        errorMsg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string errorMsg = 2;</code>
       */
      public Builder clearErrorMsg() {
        
        errorMsg_ = getDefaultInstance().getErrorMsg();
        onChanged();
        return this;
      }
      /**
       * <code>optional string errorMsg = 2;</code>
       */
      public Builder setErrorMsgBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        errorMsg_ = value;
        onChanged();
        return this;
      }

      private Object result_ = "";
      /**
       * <code>optional string result = 3;</code>
       */
      public String getResult() {
        Object ref = result_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          result_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string result = 3;</code>
       */
      public com.google.protobuf.ByteString
          getResultBytes() {
        Object ref = result_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          result_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string result = 3;</code>
       */
      public Builder setResult(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        result_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string result = 3;</code>
       */
      public Builder clearResult() {
        
        result_ = getDefaultInstance().getResult();
        onChanged();
        return this;
      }
      /**
       * <code>optional string result = 3;</code>
       */
      public Builder setResultBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        result_ = value;
        onChanged();
        return this;
      }

      private boolean event_ ;
      /**
       * <code>optional bool event = 4;</code>
       */
      public boolean getEvent() {
        return event_;
      }
      /**
       * <code>optional bool event = 4;</code>
       */
      public Builder setEvent(boolean value) {
        
        event_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool event = 4;</code>
       */
      public Builder clearEvent() {
        
        event_ = false;
        onChanged();
        return this;
      }

      private Object resultType_ = "";
      /**
       * <code>optional string resultType = 5;</code>
       */
      public String getResultType() {
        Object ref = resultType_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          resultType_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string resultType = 5;</code>
       */
      public com.google.protobuf.ByteString
          getResultTypeBytes() {
        Object ref = resultType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          resultType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string resultType = 5;</code>
       */
      public Builder setResultType(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        resultType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string resultType = 5;</code>
       */
      public Builder clearResultType() {
        
        resultType_ = getDefaultInstance().getResultType();
        onChanged();
        return this;
      }
      /**
       * <code>optional string resultType = 5;</code>
       */
      public Builder setResultTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        resultType_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:netty.RpcResponse)
    }

    // @@protoc_insertion_point(class_scope:netty.RpcResponse)
    private static final RpcResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new RpcResponse();
    }

    public static RpcResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RpcResponse>
        PARSER = new com.google.protobuf.AbstractParser<RpcResponse>() {
      public RpcResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new RpcResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RpcResponse> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<RpcResponse> getParserForType() {
      return PARSER;
    }

    public RpcResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_netty_RpcResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_netty_RpcResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\021RpcResponse.proto\022\005netty\"^\n\013RpcRespons" +
      "e\022\n\n\002ID\030\001 \001(\003\022\020\n\010errorMsg\030\002 \001(\t\022\016\n\006resul" +
      "t\030\003 \001(\t\022\r\n\005event\030\004 \001(\010\022\022\n\nresultType\030\005 \001" +
      "(\tB1\n\035com.hhy.mydubbo.protobuf.beanB\020Rpc" +
      "ResponseProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_netty_RpcResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_netty_RpcResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_netty_RpcResponse_descriptor,
        new String[] { "ID", "ErrorMsg", "Result", "Event", "ResultType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
