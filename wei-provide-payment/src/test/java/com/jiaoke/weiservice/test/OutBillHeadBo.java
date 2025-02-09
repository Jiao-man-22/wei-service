package com.jiaoke.weiservice.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class OutBillHeadBo extends TJkOutBillHead {

    @ApiModelProperty(value = "码单号")
    private String packNum;
    /**
     * 码单号 : STACK_NO
     */
    @ApiModelProperty(value = "码单号")
    private String stackNoLike;

    /**
     * 提单号(钢厂提单号) : BILL_ID
     */
    @ApiModelProperty(value = "提单号(钢厂提单号)")
    private String billIdLike;

    /**
     * 车船号(车牌号) : VEHICLE_NO
     */
    @ApiModelProperty(value = "车船号(车牌号)")
    private String vehicleNoLike;


    /**
     * 开始装车时间 : LOAD_TIME
     */
    @ApiModelProperty(value = "开始装车时间")
    private String beginLoadTime;
    /**
     * 结束装车时间 : LOAD_TIME
     */
    @ApiModelProperty(value = "结束装车时间")
    private String endLoadTime;

    /**
     * 开始发货确认时间 : LOAD_TIME
     */
    @ApiModelProperty(value = "开始发货确认时间")
    private String beginShipmentsConfirmTime;
    /**
     * 结束发货确认时间 : LOAD_TIME
     */
    @ApiModelProperty(value = "结束发货确认时间")
    private String endShipmentsConfirmTime;

    /**
     * 收货单位名称 : CONSIGNEE_COMPANY_NAME
     */
    @ApiModelProperty(value = "收货单位名称")
    private String consigneeCompanyNameLike;

    /**
     * 订货单位 : ORDER_COMPANY_NAME
     */
    @ApiModelProperty(value = "订货单位")
    private String orderCompanyNameLike;

    /**
     * 结算单位 : PAYER
     */
    @ApiModelProperty(value = "结算单位")
    private String payerLike;

    /**
     * 合同号 : ORDER_NUM
     */
    @ApiModelProperty(value = "合同号")
    private String orderNumLike;

    /**
     * 仓库代码(出库仓库代码（含厂内库、厂外库）) : WAREHOUSE_CODE
     */
    @ApiModelProperty(value = "仓库代码(出库仓库代码（含厂内库、厂外库）)")
    private String warehouseCodeLike;

    /**
     * 目的地 : END_SITE_ADDR
     */
    @ApiModelProperty(value = "目的地")
    private String endSiteAddr;

    /**
     * 收货联系人 : CONSIGNEE_CONTACT
     */
    @ApiModelProperty(value = "收货联系人")
    private String consigneeContact;

    /**
     * 收货联系人电话 : CONSIGNEE_TELE
     */
    @ApiModelProperty(value = "收货联系人电话")
    private String consigneeTele;

    /**
     * 集港地 :  PORT_NAME
     */
    @ApiModelProperty(value = "集港地")
    private String  portName;

    /**
     * 捆包号 :  PACK_NUM
     */
    @ApiModelProperty(value = "捆包号")
    private String  packNumLike;

    @ApiModelProperty(value = "物流品种代码列表")
    private List<String> transProductTypeIds;

    @ApiModelProperty(value = "处理方式列表")
    private List<String> dealFlags;

    @ApiModelProperty(value = "码单状态")
    private String stackStatus;

    /**
     * 数据来源 :  SYS_SOURCE
     */
    @ApiModelProperty(value = "数据来源")
    private String  sysSource;
    /**
     * 处理结果描述 : DEAL_DESC
     */
    @ApiModelProperty(value = "处理结果描述")
    private String dealDescLike;

    /**
     * 码单载运净重总计字段 : TOTAL_NET_WEIGHT
     */
    @ApiModelProperty(value = "码单载运净重总计")
    private BigDecimal  totalCountNetWeight;

    /**
     * 码单载运毛重总计字段 : TOTAL_GROSS_WEIGHT
     */
    @ApiModelProperty(value = "码单载运毛重总计")
    private BigDecimal  totalCountGrossWeight;

    /**
     * 码单装载件数总计字段 : TOTAL_PIECE
     */
    @ApiModelProperty(value = "码单装载件数总计")
    private Long  totalCountPiece;

    /**
     * 明细记录数总计字段 : DETAILS_COUNTS
     */
    @ApiModelProperty(value = "明细记录数总计")
    private Long  detailsTotalCounts;
    /**
     * 创建开始时间 : CREATED_TIME
     */
    @ApiModelProperty(value = "创建开始时间")
    private String createDateFrom;
    /**
     * 创建结束时间 : CREATED_TIME
     */
    @ApiModelProperty(value = "创建结束时间")
    private String createDateTo;
    /**
     * 产地 : PROD_AREA_NAME
     */
    @ApiModelProperty(value = "产地")
    private String prodAreaName;
    /**
     * 销售合同号 : SALE_CONTRACT_NUM
     */
    @ApiModelProperty(value = "销售合同号")
    private String saleContractNum;
    /**
     * 销售子项合同号 : SALE_CONTRACT_LINE_NUM
     */
    @ApiModelProperty(value = "销售子项合同号")
    private String saleContractLineNum;
    /**
     * 采购合同号 : PUR_CONTRACT_NUM
     */
    @ApiModelProperty(value = "采购合同号")
    private String purContractNum;
    /**
     * 采购子项合同号 : PUR_CONTRACT_LINE_NUM
     */
    @ApiModelProperty(value = "采购子项合同号")
    private String purContractLineNum;
    /**
     * 捆包类型 : PACK_TYPE
     */
    @ApiModelProperty(value = "捆包类型")
    private String packType;

    /**
     * 采购子项号列表（【或】查询）
     */
    private List<String> orPurContractLineNumList;
    /**
     * 钢厂资源号（【或】查询）
     */
    private List<String> orSteelMillResourceNoList;
    /**
     * 钢厂资源号（【或】查询）
     */
    private List<String> orOrderNumList;

    /**
     * 钢厂资源号（【或】查询）
     */
    private List<String> orStackNoList;
    /**
     * 采购合同号 : PUR_CONTRACT_NUM
     */
    @ApiModelProperty(value = "采购合同号")
    private List<String> orPurContractNumList;

    /**
     * 主表id列表
     */
    private List<Long> outBillHeadIdList = new ArrayList<>();

    /**
     * 数据权限
     */
    private List<List<Map>> dataGrantPermissionList;

    /**
     * 行号最小值
     */
    private int rowIdMin;
    /**
     * 行号最大值
     */
    private int rowIdMax;

    @ApiModelProperty(value = "码单号列表")
    private List<String> stackNoList;

    /**
     * 是否交易查询
     */
    private String isJyQuery;

    @ApiModelProperty(value = "操作者名称（模糊查询）")
    private String empNameLike;

    @ApiModelProperty(value = "供应商名称（模糊查询）")
    private String providerNameLike;

    /**
     * 码单量
     */
    @ApiModelProperty(value = "码单量")
    private BigDecimal sumNetWeight;

    @ApiModelProperty(value = "收货单位名称列表")
    private List<String> orConsigneeCompanyNameList;

    @ApiModelProperty(value = "结算用户列表")
    private List<String> orPayerList;

    @ApiModelProperty(value = "捆包号")
    private String packNumListStr;

    @ApiModelProperty(value = "规格")
    private String goodsSpecListStr;

    @ApiModelProperty(value = "牌号")
    private String shopSignListStr;

    @ApiModelProperty(value = "品种")
    private String kindNameListStr;

    @ApiModelProperty(value = "产地")
    private String prodAreaNameListStr;

    @ApiModelProperty(value = "捆包号列表")
    private List<String> packNumList;

    @ApiModelProperty(value = "规格列表")
    private List<String> goodsSpecList;

    @ApiModelProperty(value = "牌号列表")
    private List<String> shopSignList;

    @ApiModelProperty(value = "品种列表")
    private List<String> kindNameList;

    @ApiModelProperty(value = "产地列表")
    private List<String> prodAreaNameList;

    @ApiModelProperty(value = "产品类型")
    private String productType;

    @ApiModelProperty(value = "欧冶提单号")
    private String shgtBillId;

    @ApiModelProperty(value = "非平台合约类型（码单业务类型）")
    private String noContractTypePlat;

    @ApiModelProperty(value = "是否存在红冲的明细(0-不存在，1-存在)")
    private String existsRedFlag;

    @ApiModelProperty(value = "合同号列表")
    private List<String> orderNumList;

    @ApiModelProperty(value = "默认查询一个月")
    private String oneMonthTag;
    /**
     * 规格
     */
    private String goodsSpec;

    /**
     * 牌号
     */
    private String shopSign;

    /**
     * 品名
     */
    private String kindName;
    /**
     * 交易品种名称 : TRADE_PRODUCT_TYPE_NAME
     */
    @ApiModelProperty(value = "交易品种名称")
    private String tradeProductTypeName;
    @ApiModelProperty(value = "数据来源")
    private List<String> sysSourceList;
    // @ApiModelProperty(value = "业务来源")
    // private List<String> businessSourceList;
}
