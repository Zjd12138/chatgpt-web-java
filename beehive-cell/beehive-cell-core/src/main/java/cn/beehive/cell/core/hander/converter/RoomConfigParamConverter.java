package cn.beehive.cell.core.hander.converter;

import cn.beehive.base.domain.entity.RoomConfigParamDO;
import cn.beehive.base.util.FrontUserUtil;
import cn.beehive.cell.core.domain.bo.CellConfigPermissionBO;
import cn.beehive.cell.core.domain.bo.RoomConfigParamBO;
import cn.beehive.cell.core.domain.vo.CellConfigVO;
import cn.beehive.cell.core.domain.vo.RoomConfigParamVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author hncboy
 * @date 2023/6/3
 * 房间配置参数相关转换
 */
@Mapper
public interface RoomConfigParamConverter {

    RoomConfigParamConverter INSTANCE = Mappers.getMapper(RoomConfigParamConverter.class);

    /**
     * CellConfigVO 转 RoomConfigParamVO
     *
     * @param cellConfigVO CellConfigVO
     * @return RoomConfigParamVO
     */
    RoomConfigParamVO cellConfigVOToVO(CellConfigVO cellConfigVO);

    /**
     * CellConfigPermissionBO 转 RoomConfigParamBO
     *
     * @param cellConfigPermissionBO CellConfigPermissionBO
     * @return RoomConfigParamBO
     */
    RoomConfigParamBO cellConfigPermissionBOToBO(CellConfigPermissionBO cellConfigPermissionBO);

    /**
     * RoomConfigParamBO 转 RoomConfigParamDO
     *
     * @param roomConfigParamBO RoomConfigParamBO
     * @param roomId            房间 id
     * @return RoomConfigParamDO
     */
    default RoomConfigParamDO boToEntity(RoomConfigParamBO roomConfigParamBO, Long roomId) {
        RoomConfigParamDO roomConfigParamDO = new RoomConfigParamDO();
        roomConfigParamDO.setUserId(FrontUserUtil.getUserId());
        roomConfigParamDO.setRoomId(roomId);
        roomConfigParamDO.setCellConfigCode(roomConfigParamBO.getCellConfigCode());
        roomConfigParamDO.setValue(roomConfigParamBO.getValue());
        roomConfigParamDO.setIsDeleted(false);
        return roomConfigParamDO;
    }
}
