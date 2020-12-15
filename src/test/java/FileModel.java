import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: FileModel
 * @Date: 2020/8/13 10:05
 * @Operation:
 * @Description: 文件参数信息
 *
 */
public class FileModel {

    /**
     * 需要执行的所有文件（全路径）
     */
    private List<String> allFilePaths;
    /**
     * 需要执行的所有文件名称
     */
    private List<String> allFileName;

    /**
     * 需要执行的文件所有结果MML文件（全路径）
     */
    private List<String> allMMLPaths;

    /**
     * 需要执行的文件所有结果MML文件名称,源文件关系
     */
    private Map<String,String> allMMLName;

    /**
     * 执行结果MML文件名称
     */
    private List<String> allResultMMLName;

    public FileModel() {
        this.allFilePaths = new ArrayList<>();
        this.allFileName = new ArrayList<>();
        this.allMMLPaths = new ArrayList<>();
        this.allMMLName = new HashMap<>();
        this.allResultMMLName = new ArrayList<>();
    }

    public List<String> getAllFilePaths() {
        return allFilePaths;
    }

    public void setAllFilePaths(List<String> allFilePaths) {
        this.allFilePaths = allFilePaths;
    }

    public List<String> getAllFileName() {
        return allFileName;
    }

    public void setAllFileName(List<String> allFileName) {
        this.allFileName = allFileName;
    }

    public List<String> getAllMMLPaths() {
        return allMMLPaths;
    }

    public void setAllMMLPaths(List<String> allMMLPaths) {
        this.allMMLPaths = allMMLPaths;
    }

    public Map<String, String> getAllMMLName() {
        return allMMLName;
    }

    public void setAllMMLName(Map<String, String> allMMLName) {
        this.allMMLName = allMMLName;
    }

    public List<String> getAllResultMMLName() {
        return allResultMMLName;
    }

    public void setAllResultMMLName(List<String> allResultMMLName) {
        this.allResultMMLName = allResultMMLName;
    }

    public void clear(){
        this.allFilePaths.clear();
        this.allFileName.clear();
        this.allMMLPaths.clear();
        this.allMMLName.clear();
        this.allResultMMLName.clear();
    }
}
