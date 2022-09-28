package edu.zut.epidemic.service;

import edu.zut.epidemic.entity.Resident;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.zut.epidemic.entity.dto.ResidentDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author roydon
 * @since 2022-09-28
 */
public interface IResidentService extends IService<Resident> {

    Resident register(ResidentDTO residentDTO);
}
