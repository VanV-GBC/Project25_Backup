package ca.gbc.comp3074.project_25;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converters {
    @TypeConverter
    public String get_string(List<String> str) {
        if (str == null)
            return null;
        StringBuilder tags = new StringBuilder();
        for (String s : str) tags.append(s).append(",");
        return tags.toString();
    }

    @TypeConverter
    public List<String> set_string(String str) {
        if (str == null)
            return null;
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }
}
