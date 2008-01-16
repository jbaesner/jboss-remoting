package org.jboss.cx.remoting.core.stream;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.jboss.cx.remoting.spi.stream.StreamDetector;
import org.jboss.cx.remoting.spi.stream.StreamSerializerFactory;
import org.jboss.cx.remoting.stream.ObjectSink;
import org.jboss.cx.remoting.stream.ObjectSource;
import org.jboss.cx.remoting.stream.ProgressStream;

/**
 *
 */
public final class DefaultStreamDetector implements StreamDetector {
    public StreamSerializerFactory detectStream(Object candidate) {
        if (candidate instanceof InputStream) {
            return new InputStreamStreamSerializerFactory();
        } else if (candidate instanceof OutputStream) {
            return new OutputStreamStreamSerailizerFactory();
        } else if (candidate instanceof ObjectSource) {
            return new ObjectSourceStreamSerializerFactory();
        } else if (candidate instanceof ObjectSink) {
            return new ObjectSinkStreamSerializerFactory();
        } else if (candidate instanceof ProgressStream) {
            return new ProgressStreamStreamSerializerFactory();
        } else if (candidate instanceof Iterator) {
            return new IteratorStreamSerializerFactory();
        } else {
            return null;
        }
    }
}