package com.waihai.ycodeassistant.core.saver;

import cn.hutool.core.util.StrUtil;
import com.waihai.ycodeassistant.ai.model.HtmlCodeResult;
import com.waihai.ycodeassistant.exception.BusinessException;
import com.waihai.ycodeassistant.exception.ErrorCode;
import com.waihai.ycodeassistant.model.enums.CodeGenTypeEnum;

public class HtmlCodeFileSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult> {
    @Override
    protected CodeGenTypeEnum getCodeGenTypeEnum() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    protected void saveFiles(HtmlCodeResult result, String baseDirPath) {
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
    }

    @Override
    protected void validateContent(HtmlCodeResult result) {
        super.validateContent(result);
        // HTML 代码不能为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML 代码不能为空");
        }
    }
}
