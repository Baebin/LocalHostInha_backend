package com.piebin.web.geomap;

import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class GeoMapJsonParser {
    private static Logger logger = LoggerFactory.getLogger(GeoMapJsonParser.class);
    private static String PATH_SRC = "\\src\\main";
    private static String PATH_JSON = "\\resources\\json";
    private static String FILE_JSON = "jsonformatter.json";

    public String run() throws IOException {
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //request.getServletContext().getRealPath("/");

        File file = new File("");
        String path = "";
        path = file.getAbsolutePath();
        path += PATH_SRC + PATH_JSON + "\\" + FILE_JSON;

        File json = new File(path);
        logger.info(path + ": " + json.exists());

        if (json.exists()) {
            FileInputStream fileInputStream = new FileInputStream(json);
            InputStreamReader inputStreamReader = new InputStreamReader(
                    fileInputStream, "UTF-8"
            );
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String value = "";

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty())
                    break;
                value += line + "\n";
            }
            logger.info(value);

            JsonParser parser = new JsonParser();
        }

        return path;
    }
}
