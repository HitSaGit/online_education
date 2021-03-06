package com.atguigu.guli.service.edu.feign.fallback;

import com.atguigu.guli.common.base.result.R;
import com.atguigu.guli.service.edu.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OssFileServiceFallBack implements OssFileService {

    @Override
    public R test() {
        return R.error();
    }

    // 一旦oss服务中的该方法调用失败，则执行本地的这个方法
    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error();
    }
}
