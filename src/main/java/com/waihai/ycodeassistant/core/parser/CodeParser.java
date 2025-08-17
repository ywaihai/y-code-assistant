package com.waihai.ycodeassistant.core.parser;

/**
 * 代码解析器策略接口
 */
public interface CodeParser<T> {

    T parseCode(String codeContent);

}
