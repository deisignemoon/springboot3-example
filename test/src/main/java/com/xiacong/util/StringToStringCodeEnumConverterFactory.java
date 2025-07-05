package com.xiacong.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * SpringMvc的ConverterFactory实现 用于BaseCodeEnum的数据绑定.
 * @param <E> 实现BaseCodeEnum的枚举类型
 * @author liweibo
 */
public class StringToStringCodeEnumConverterFactory<E extends Enum<E> & BaseCodeEnum<E, String>> implements ConverterFactory<String, E> {
    @Override
    public <T extends E> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToBaseCodeEnum(targetType);
    }

    private class StringToBaseCodeEnum<T extends E> implements Converter<String, T> {
        private final Class<T> type;

        public StringToBaseCodeEnum(Class<T> type) {
            this.type = type;
        }

        @Override
        public T convert(String source) {
            //return CodeEnumUtil.codeOf(type, source);
            return null;
        }
    }
}
