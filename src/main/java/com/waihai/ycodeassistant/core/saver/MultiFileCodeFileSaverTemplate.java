package com.waihai.ycodeassistant.core.saver;

import cn.hutool.core.util.StrUtil;
import com.waihai.ycodeassistant.ai.model.MultiFileCodeResult;
import com.waihai.ycodeassistant.exception.BusinessException;
import com.waihai.ycodeassistant.exception.ErrorCode;
import com.waihai.ycodeassistant.model.enums.CodeGenTypeEnum;

public class MultiFileCodeFileSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {
    @Override
    protected CodeGenTypeEnum getCodeGenTypeEnum() {
        return CodeGenTypeEnum.MULTI_FILE;
    }

    @Override
    protected void saveFiles(MultiFileCodeResult result, String baseDirPath) {
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
        writeToFile(baseDirPath, "style.css", result.getCssCode());
        writeToFile(baseDirPath, "script.js", result.getJsCode());
    }

    @Override
    protected void validateContent(MultiFileCodeResult result) {
        super.validateContent(result);
        // 至少要有 HTML 代码，CSS 和 JS 可以为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码内容不能为空");
        }
    }
}
