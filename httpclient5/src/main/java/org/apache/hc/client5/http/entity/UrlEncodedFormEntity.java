/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.hc.client5.http.entity;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.hc.client5.http.utils.URLEncodedUtils;
import org.apache.hc.core5.annotation.NotThreadSafe;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.entity.ContentType;
import org.apache.hc.core5.http.entity.StringEntity;

/**
 * An entity composed of a list of url-encoded pairs.
 * This is typically useful while sending an HTTP POST request.
 *
 * @since 4.0
 */
@NotThreadSafe // AbstractHttpEntity is not thread-safe
public class UrlEncodedFormEntity extends StringEntity {

    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters in the specified encoding.
     *
     * @param parameters iterable collection of name/value pairs
     * @param charset encoding the name/value pairs be encoded with
     *
     * @since 4.2
     */
    public UrlEncodedFormEntity (
        final Iterable <? extends NameValuePair> parameters,
        final Charset charset) {
        super(URLEncodedUtils.format(parameters,
                charset != null ? charset : StandardCharsets.ISO_8859_1),
                ContentType.create(URLEncodedUtils.CONTENT_TYPE, charset));
    }

    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters with the default encoding of {@link StandardCharsets#ISO_8859_1}
     *
     * @param parameters list of name/value pairs
     */
    public UrlEncodedFormEntity (final List <? extends NameValuePair> parameters){
        this(parameters, null);
    }

    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters with the default encoding of {@link StandardCharsets#ISO_8859_1}
     *
     * @param parameters iterable collection of name/value pairs
     *
     * @since 4.2
     */
    public UrlEncodedFormEntity (
        final Iterable <? extends NameValuePair> parameters) {
        this(parameters, null);
    }

}
