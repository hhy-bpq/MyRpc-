// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RpcProto.proto

package com.cyp.chx.rcenter.protobuff.bean;

public final class RpcProto {
  private RpcProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ProtoDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:netty.ProtoData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 ID = 1;</code>
     */
    long getID();

    /**
     * <code>optional bool twoWay = 2;</code>
     */
    boolean getTwoWay();

    /**
     * <code>optional bool event = 3;</code>
     */
    boolean getEvent();

    /**
     * <code>optional bool isRequest = 4;</code>
     */
    boolean getIsRequest();

    /**
     * <code>optional string status = 5;</code>
     */
    String getStatus();
    /**
     * <code>optional string status = 5;</code>
     */
    com.google.protobuf.ByteString
        getStatusBytes();

    /**
     * <code>optional string data = 6;</code>
     */
    String getData();
    /**
     * <code>optional string data = 6;</code>
     */
    com.google.protobuf.ByteString
        getDataBytes();
  }
  /**
   * Protobuf type {@code netty.ProtoData}
   */
  public  static final class ProtoData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:netty.ProtoData)
      ProtoDataOrBuilder {
    // Use ProtoData.newBuilder() to construct.
    private ProtoData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ProtoData() {
      iD_ = 0L;
      twoWay_ = false;
      event_ = false;
      isRequest_ = false;
      status_ = "";
      data_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private ProtoData(
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
            case 16: {

              twoWay_ = input.readBool();
              break;
            }
            case 24: {

              event_ = input.readBool();
              break;
            }
            case 32: {

              isRequest_ = input.readBool();
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();

              status_ = s;
              break;
            }
            case 50: {
              String s = input.readStringRequireUtf8();

              data_ = s;
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
      return RpcProto.internal_static_netty_ProtoData_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RpcProto.internal_static_netty_ProtoData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ProtoData.class, Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private long iD_;
    /**
     * <code>optional int64 ID = 1;</code>
     */
    public long getID() {
      return iD_;
    }

    public static final int TWOWAY_FIELD_NUMBER = 2;
    private boolean twoWay_;
    /**
     * <code>optional bool twoWay = 2;</code>
     */
    public boolean getTwoWay() {
      return twoWay_;
    }

    public static final int EVENT_FIELD_NUMBER = 3;
    private boolean event_;
    /**
     * <code>optional bool event = 3;</code>
     */
    public boolean getEvent() {
      return event_;
    }

    public static final int ISREQUEST_FIELD_NUMBER = 4;
    private boolean isRequest_;
    /**
     * <code>optional bool isRequest = 4;</code>
     */
    public boolean getIsRequest() {
      return isRequest_;
    }

    public static final int STATUS_FIELD_NUMBER = 5;
    private volatile Object status_;
    /**
     * <code>optional string status = 5;</code>
     */
    public String getStatus() {
      Object ref = status_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        status_ = s;
        return s;
      }
    }
    /**
     * <code>optional string status = 5;</code>
     */
    public com.google.protobuf.ByteString
        getStatusBytes() {
      Object ref = status_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATA_FIELD_NUMBER = 6;
    private volatile Object data_;
    /**
     * <code>optional string data = 6;</code>
     */
    public String getData() {
      Object ref = data_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        data_ = s;
        return s;
      }
    }
    /**
     * <code>optional string data = 6;</code>
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      Object ref = data_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        data_ = b;
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
      if (twoWay_ != false) {
        output.writeBool(2, twoWay_);
      }
      if (event_ != false) {
        output.writeBool(3, event_);
      }
      if (isRequest_ != false) {
        output.writeBool(4, isRequest_);
      }
      if (!getStatusBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, status_);
      }
      if (!getDataBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, data_);
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
      if (twoWay_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(2, twoWay_);
      }
      if (event_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, event_);
      }
      if (isRequest_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(4, isRequest_);
      }
      if (!getStatusBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, status_);
      }
      if (!getDataBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, data_);
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
      if (!(obj instanceof ProtoData)) {
        return super.equals(obj);
      }
      ProtoData other = (ProtoData) obj;

      boolean result = true;
      result = result && (getID()
          == other.getID());
      result = result && (getTwoWay()
          == other.getTwoWay());
      result = result && (getEvent()
          == other.getEvent());
      result = result && (getIsRequest()
          == other.getIsRequest());
      result = result && getStatus()
          .equals(other.getStatus());
      result = result && getData()
          .equals(other.getData());
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
      hash = (37 * hash) + TWOWAY_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getTwoWay());
      hash = (37 * hash) + EVENT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getEvent());
      hash = (37 * hash) + ISREQUEST_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsRequest());
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus().hashCode();
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ProtoData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ProtoData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ProtoData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ProtoData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ProtoData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ProtoData parseFrom(
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
    public static Builder newBuilder(ProtoData prototype) {
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
     * Protobuf type {@code netty.ProtoData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:netty.ProtoData)
        ProtoDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RpcProto.internal_static_netty_ProtoData_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RpcProto.internal_static_netty_ProtoData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ProtoData.class, Builder.class);
      }

      // Construct using com.cyp.chx.rcenter.protobuff.bean.RpcProto.ProtoData.newBuilder()
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

        twoWay_ = false;

        event_ = false;

        isRequest_ = false;

        status_ = "";

        data_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RpcProto.internal_static_netty_ProtoData_descriptor;
      }

      public ProtoData getDefaultInstanceForType() {
        return ProtoData.getDefaultInstance();
      }

      public ProtoData build() {
        ProtoData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ProtoData buildPartial() {
        ProtoData result = new ProtoData(this);
        result.iD_ = iD_;
        result.twoWay_ = twoWay_;
        result.event_ = event_;
        result.isRequest_ = isRequest_;
        result.status_ = status_;
        result.data_ = data_;
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
        if (other instanceof ProtoData) {
          return mergeFrom((ProtoData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ProtoData other) {
        if (other == ProtoData.getDefaultInstance()) return this;
        if (other.getID() != 0L) {
          setID(other.getID());
        }
        if (other.getTwoWay() != false) {
          setTwoWay(other.getTwoWay());
        }
        if (other.getEvent() != false) {
          setEvent(other.getEvent());
        }
        if (other.getIsRequest() != false) {
          setIsRequest(other.getIsRequest());
        }
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
          onChanged();
        }
        if (!other.getData().isEmpty()) {
          data_ = other.data_;
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
        ProtoData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ProtoData) e.getUnfinishedMessage();
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

      private boolean twoWay_ ;
      /**
       * <code>optional bool twoWay = 2;</code>
       */
      public boolean getTwoWay() {
        return twoWay_;
      }
      /**
       * <code>optional bool twoWay = 2;</code>
       */
      public Builder setTwoWay(boolean value) {
        
        twoWay_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool twoWay = 2;</code>
       */
      public Builder clearTwoWay() {
        
        twoWay_ = false;
        onChanged();
        return this;
      }

      private boolean event_ ;
      /**
       * <code>optional bool event = 3;</code>
       */
      public boolean getEvent() {
        return event_;
      }
      /**
       * <code>optional bool event = 3;</code>
       */
      public Builder setEvent(boolean value) {
        
        event_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool event = 3;</code>
       */
      public Builder clearEvent() {
        
        event_ = false;
        onChanged();
        return this;
      }

      private boolean isRequest_ ;
      /**
       * <code>optional bool isRequest = 4;</code>
       */
      public boolean getIsRequest() {
        return isRequest_;
      }
      /**
       * <code>optional bool isRequest = 4;</code>
       */
      public Builder setIsRequest(boolean value) {
        
        isRequest_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool isRequest = 4;</code>
       */
      public Builder clearIsRequest() {
        
        isRequest_ = false;
        onChanged();
        return this;
      }

      private Object status_ = "";
      /**
       * <code>optional string status = 5;</code>
       */
      public String getStatus() {
        Object ref = status_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          status_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string status = 5;</code>
       */
      public com.google.protobuf.ByteString
          getStatusBytes() {
        Object ref = status_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          status_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string status = 5;</code>
       */
      public Builder setStatus(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string status = 5;</code>
       */
      public Builder clearStatus() {
        
        status_ = getDefaultInstance().getStatus();
        onChanged();
        return this;
      }
      /**
       * <code>optional string status = 5;</code>
       */
      public Builder setStatusBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        status_ = value;
        onChanged();
        return this;
      }

      private Object data_ = "";
      /**
       * <code>optional string data = 6;</code>
       */
      public String getData() {
        Object ref = data_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          data_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string data = 6;</code>
       */
      public com.google.protobuf.ByteString
          getDataBytes() {
        Object ref = data_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          data_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string data = 6;</code>
       */
      public Builder setData(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string data = 6;</code>
       */
      public Builder clearData() {
        
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }
      /**
       * <code>optional string data = 6;</code>
       */
      public Builder setDataBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        data_ = value;
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


      // @@protoc_insertion_point(builder_scope:netty.ProtoData)
    }

    // @@protoc_insertion_point(class_scope:netty.ProtoData)
    private static final ProtoData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ProtoData();
    }

    public static ProtoData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ProtoData>
        PARSER = new com.google.protobuf.AbstractParser<ProtoData>() {
      public ProtoData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ProtoData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ProtoData> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ProtoData> getParserForType() {
      return PARSER;
    }

    public ProtoData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_netty_ProtoData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_netty_ProtoData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016RpcProto.proto\022\005netty\"g\n\tProtoData\022\n\n\002" +
      "ID\030\001 \001(\003\022\016\n\006twoWay\030\002 \001(\010\022\r\n\005event\030\003 \001(\010\022" +
      "\021\n\tisRequest\030\004 \001(\010\022\016\n\006status\030\005 \001(\t\022\014\n\004da" +
      "ta\030\006 \001(\tB.\n\"com.cyp.chx.rcenter.protobuf" +
      "f.beanB\010RpcProtob\006proto3"
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
    internal_static_netty_ProtoData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_netty_ProtoData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_netty_ProtoData_descriptor,
        new String[] { "ID", "TwoWay", "Event", "IsRequest", "Status", "Data", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
