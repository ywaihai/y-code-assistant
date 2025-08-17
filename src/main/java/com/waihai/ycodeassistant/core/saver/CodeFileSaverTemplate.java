package com.waihai.ycodeassistant.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.waihai.ycodeassistant.exception.BusinessException;
import com.waihai.ycodeassistant.exception.ErrorCode;
import com.waihai.ycodeassistant.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

public abstract class CodeFileSaverTemplate<T> {

    /**
     * 文件保存的根目录
     */
    private static final String FILE_SAVE_ROOT_DIR = System.getProperty("user.dir") + "/tmp/code_output";

    public final File saveCode(T result) {
        // 1.校验
        validateContent(result);
        // 2.构建路径
        String baseDirPath = buildUniqueDir();
        // 3.保存为文件
        saveFiles(result, baseDirPath);
        // 4.返回文件目录对象
        return new File(baseDirPath);
    }

    protected void validateContent(T result) {
        if (result == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "代码结果对象不能为空");
        }
    }

    /**
     * 构建文件的唯一路径：tmp/code_output/bizType_雪花 ID
     *
     * @return 文件路径
     */
    protected String buildUniqueDir() {
        String bizType = getCodeGenTypeEnum().getValue();
        String uniqueDirName = StrUtil.format("{}_{}", bizType, IdUtil.getSnowflakeNextIdStr());
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    /**
     * 保存单个文件
     *
     * @param dirPath
     * @param filename
     * @param content
     */
    public final void writeToFile(String dirPath, String filename, String content) {
        String filePath = dirPath + File.separator + filename;
        FileUtil.writeString(content, filePath, StandardCharsets.UTF_8);
    }

    protected abstract CodeGenTypeEnum getCodeGenTypeEnum();

    protected abstract void saveFiles(T result, String baseDirPath);
}
