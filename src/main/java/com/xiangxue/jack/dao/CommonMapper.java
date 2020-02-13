package com.xiangxue.jack.dao;


import com.xiangxue.jack.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CommonMapper {
    
    int saveArea(ConsultConfigArea area);
    
    int deleteArea(Map param);
    
    int deleteAreaAll();
    
    int updateArea(ConsultConfigArea area);
    
    List<ConsultConfigArea> queryAreaByAreaCode(Map param);
    
    List<ConsultRecord> queryConsultRecords(Map param);
    
    List<Map> queryUserByPsptId(Map param);
    
    int saveUser(ConsultIdCardInfo record);
    
    int saveRecord(ConsultRecord record);
    
    int saveRecordCount(ConsultRecordCount recordCount);
    
    List<ConsultRecord> queryRecords(Map param);
    
    List<ConsultRecord> queryRecordshaveH(Map param);
    
    //@Select("select * from consult_content where type = #{type}")
    //    @Select({"<script>", "select * from consult_content a where a.state = 0",
    //            "<if test='type != null'>",
    //            "and a.type = #{type,jdbcType=VARCHAR}", "</if>",
    //            "order by a.itemindex", "</script>"})
    List<ConsultContent> queryContent(Map param);
    
    int updateRecords(Map param);
    
    int updateRecordsByPsptId(Map param);
    
    List<ConsultRecordCount> queryRecordCount(Map param);
    
    int updateRecordCount(Map param);
    
    List<ConsultConfigArea> qryArea(Map param);
    
    List<ConsultContract> qryContracts(Map param);
    
    int saveContracts(List<ConsultContract> contracts);
    
    int updateConsultRecord(Map param);

    @Select("select * from consult_configarea where areaCode=#{areaCode}")
    List<ConsultConfigArea> queryAreaById(String areaCode);

    @Insert("insert into consult_configarea(AREACODE,AREANAME,STATE) values(#{areaCode},#{areaName},#{state})")
    int addArea(ConsultConfigArea area);

    @Insert("insert into zg_goods (goodCode, goodName, count\n" +
            "\t\t)\n" +
            "\t\tvalues (#{goodCode,jdbcType=VARCHAR}, #{goodName,jdbcType=VARCHAR},\n" +
            "\t\t#{count,jdbcType=INTEGER}\n" +
            "\t\t)")
    int addGood(ZgGoods zgGoods);

    @Select("select * from zg_goods where goodCode=#{goodCode}")
    List<ZgGoods> queryGoodsByGoodCode(String goodCode);

    @Select("select * from zg_goods")
    List<ZgGoods> queryAll();

    @Update("update zg_ticket set version=versoin+1 where ticketId = #{ticketId} and version = #{version}")
    int updateLock(Map map);


    @Select("select * from zg_ticket where ticketId = #{ticketId}")
    List<ZgTicket> queryTicketById(String ticketId);

    @Update("update zg_ticket set ticketCount=ticketCount-#{ticketCount} where ticketId = #{ticketId} and ticketCount >= #{ticketCount}")
    int updateTicket(ZgTicket zgTicket);
}
