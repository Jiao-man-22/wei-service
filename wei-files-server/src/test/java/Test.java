
import com.jiaoke.file.server.FileServerApplication;
import com.jiaoke.file.server.dao.FileMapper;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest(classes = {FileServerApplication.class})
@RunWith(SpringRunner.class)
public class Test {
    @Resource
    private FileMapper fileMapper;

    @org.junit.Test
    public void getInfo(){
        BaseFileInfo baseFileInfo = fileMapper.selectById(1L);
        System.out.println(baseFileInfo.getFileId());
    }



}
