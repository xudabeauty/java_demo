package com.saas.ec.handler.process;

import com.saas.ec.handler.model.ActivityTypeEnum;
import com.saas.ec.handler.model.DocRequest;

public interface ActivityHandler extends Handler {
    ActivityTypeEnum getSupportEnum();


    void createDoc(DocRequest request);
}
