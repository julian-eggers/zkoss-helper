package com.itelg.zkoss.helper.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.zkoss.util.media.Media;

public class FileUploadHelper
{
    public static final InputStream upload(Media media) throws IOException
    {
        return media.isBinary() ? media.getStreamData() : new ByteArrayInputStream(media.getStringData().getBytes(StandardCharsets.UTF_8));
    }
}