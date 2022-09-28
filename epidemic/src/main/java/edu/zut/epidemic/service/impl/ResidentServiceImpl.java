package edu.zut.epidemic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zut.epidemic.common.Constants;
import edu.zut.epidemic.entity.Resident;
import edu.zut.epidemic.entity.dto.ResidentDTO;
import edu.zut.epidemic.exception.ServiceException;
import edu.zut.epidemic.mapper.ResidentMapper;
import edu.zut.epidemic.service.IResidentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roydon
 * @since 2022-09-28
 */
@Service
public class ResidentServiceImpl extends ServiceImpl<ResidentMapper, Resident> implements IResidentService {


    @Override
    public Resident register(ResidentDTO residentDTO) {

        Resident one = getResidentInfo(residentDTO);
        if (one==null) {
            // 数据库没有此数据，则更新到数据库
            one = new Resident();
            residentDTO.setUpdateTime(LocalDateTime.now());
            BeanUtils.copyProperties(residentDTO,one);
            save(one);
        }else {
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }
        return one;
    }




    private Resident getResidentInfo(ResidentDTO residentDTO) {
        LambdaQueryWrapper<Resident> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Resident::getName, residentDTO.getName());
        queryWrapper.eq(Resident::getPassword, residentDTO.getPassword());
        Resident one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}
