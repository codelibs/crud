/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.codelibs.crud.base;

/**
 * @author shinsuke
 */
public class CrudMessageException extends RuntimeException {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 4564000116499132363L;

    private String messageId;

    private Object[] args;

    /**
     * @return Returns the messageId.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId The messageId to set.
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return Returns the args.
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     * @param args The args to set.
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }

    public CrudMessageException(String messageId) {
        super(messageId);
        this.messageId = messageId;
    }

    public CrudMessageException(String messageId, Object[] args) {
        super(messageId);
        this.messageId = messageId;
        this.args = args;
    }

    public CrudMessageException(String messageId, String message,
            Throwable cause) {
        super(message, cause);
        this.messageId = messageId;
    }

    public CrudMessageException(String messageId, Object[] args,
            String message, Throwable cause) {
        super(message, cause);
        this.messageId = messageId;
        this.args = args;
    }

    public CrudMessageException(String messageId, String message) {
        super(message);
        this.messageId = messageId;
    }

    public CrudMessageException(String messageId, Object[] args, String message) {
        super(message);
        this.messageId = messageId;
        this.args = args;
    }

    public CrudMessageException(String messageId, Throwable cause) {
        super(cause);
        this.messageId = messageId;
    }

    public CrudMessageException(String messageId, Object[] args, Throwable cause) {
        super(cause);
        this.messageId = messageId;
        this.args = args;
    }

}
