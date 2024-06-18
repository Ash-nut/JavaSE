package cn.helloworld1999;
import java.util.Scanner;
import java.util.Arrays;
/**
 * @author XinruiYi
 * @author yixinrui@helloworld1999.cn
 * @version 1.1.0
 */
public class DrugManagementSystem {
    static String[] strDrugsInformaction = new String[]{
        "230714204045 - 盖中盖 - 南京 - 18 - 88 - 998",
        "230714204110 - 新盖中盖 - 南京 - 28 - 188 - 1000",
        "230714204101 - 巨能钙 - 上海 - 26 - 200 - 1200",
        "230714204052 - 六味地黄丸 - 南京 - 12 - 30 - 2000",
        "230714204050 - 999感冒灵 - 广州 - 5  - 15 - 1210"
    };  
    static public Drug[] drugs = new Drug[0];  

    static public Drug[] initDrugs(String[] strArray){
        Drug[] drugs = new Drug[strArray.length];
        for(int i = 0;i<strArray.length;i++){
            drugs[i] = new Drug(
            strArray[i].replaceAll(" ","").split("-")[0], 
            strArray[i].replaceAll(" ","").split("-")[1], 
            strArray[i].replaceAll(" ","").split("-")[2], 
            Double.parseDouble(strArray[i].replaceAll(" ","").split("-")[3]), 
            Double.parseDouble(strArray[i].replaceAll(" ","").split("-")[4]), 
            Integer.parseInt(strArray[i].replaceAll(" ","").split("-")[5])
            );
        }
        return drugs;
    }

    static public void menu(){
        System.out.println("1.查询所有药品信息");
        System.out.println("2.添加一条药品信息");
        System.out.println("3.根据药品编号修改药品详情中的单价、库存、产地信息");
        System.out.println("4.根据编号删除指定药品信息");
        System.out.println("5.根据编号查询指定的药品信息");
        System.out.println("6.显示进价高于15元在南京生产的药品信息");
        System.out.println("7.计算指定地区药品的售卖的平均价格");
        System.out.println("8.找出售卖价格最高的药品信息");
        System.out.println("9.根据药品的进价进行升序排序");
        System.out.println("10.统计不同产地的药品总数及详细的商品信息");
        System.out.println("11.退出");
        Scanner sc = new Scanner(System.in);
        byte key = sc.nextByte();
        switch (key) {
            case 1:
                showDrugsInformaction(DrugManagementSystem.drugs);
                break;
            case 2:
                DrugManagementSystem.drugs = createNewDrug(drugs);
                break;
            case 3:
                DrugManagementSystem.drugs = updataDrug(DrugManagementSystem.drugs);
                break;
            case 4:
                DrugManagementSystem.drugs = dropDrugInformaction(DrugManagementSystem.drugs);
                break;
            case 5:
                retrieveDrug(DrugManagementSystem.drugs);
                break;
            case 6:
                showPurcasingPriceMoreThanThatAndPlaceOfOrigInThere();
                break;
            case 7:
            getPlaceOfOriginASP(DrugManagementSystem.drugs);
                break;
            case 8:
                unitPrice(DrugManagementSystem.drugs);
                break;
            case 9:
                DrugManagementSystem.drugs = bubbleSort(DrugManagementSystem.drugs);
                showDrugsInformaction(DrugManagementSystem.drugs);
                break;
            case 10:
                showPlaceOfOriginAndNum(DrugManagementSystem.drugs);
                break;
            case 11:
                System.exit(0);
                break;
            default:
                System.out.println("非法输入");
                break;
        }
    }
    static public void showDrugsInformaction(Drug[] drugs){
        System.out.println("全部药品信息");
        System.out.println("药品编号 | 药品名称 | 产地 | 进价 | 单价 | 库存");
        for(int i = 0;i<drugs.length;i++){
            System.out.println(drugs[i].drugNumber+" | "+drugs[i].drugName+" | "+drugs[i].placeOfOrigin+" | "+drugs[i].purchasingPrice+" | "+drugs[i].unitPrice+" | "+drugs[i].quantityInStock);
        }
    }

    static public int cheakInputDrugNumAndReturnIndex(String str,Drug[] drugs){
        if(!str.matches("[2-9][0-9]{11}")){
            System.out.println("输入的药品编号格式错误（正确格式:[2-9][0-9]{11}");
            return -2;
        }
        for(int i = 0;i<drugs.length;i++){
            if (str.equals(drugs[i].drugNumber)) {
                return i;
            }
        }
        return -1;
    }

    static public Drug[] updataDrug(Drug[] drugs){
        System.out.println("输入待修改药物的药物编号:");
        Scanner sc = new Scanner(System.in);
        String strDrugNum = sc.next();
        int i = cheakInputDrugNumAndReturnIndex(strDrugNum, drugs);
        if (i == -2) {
            System.out.println("输入格式有误");
        }else if (i == -1) {
            System.out.println("系统未收录该药物");
        }else{
            System.out.println("药品编号 | 药品名称 | 产地 | 进价 | 单价 | 库存");
            System.out.println(drugs[i].drugNumber+" | "+drugs[i].drugName+" | "+drugs[i].placeOfOrigin+" | "+drugs[i].purchasingPrice+" | "+drugs[i].unitPrice+" | "+drugs[i].quantityInStock);
            System.out.println("输入你想修改的信息(1.单价 | 2.库存 | 3.产地信息");
            byte key = sc.nextByte();
            switch (key) {
                case 1:
                    System.out.println("修改单价为:");
                    drugs[i].setUnitPric();
                    break;
                case 2:
                    System.out.println("修改库存为:");
                    drugs[i].setQuantityInStock();
                    break;
                case 3:
                    System.out.println("修改产地信息为:");
                    drugs[i].setplaceOfOrigin();
                    break;
                default:
                System.out.println("非法输入");
                    break;
            }
        }
        return drugs;
    }
    static public Drug[] createNewDrug(Drug[] drugs){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入想要创建的药品【药品编号】:");
        String strDrugNum = sc.next();
        if (cheakInputDrugNumAndReturnIndex(strDrugNum, drugs)==-2){
            return drugs;
        }

        if (cheakInputDrugNumAndReturnIndex(strDrugNum, drugs) == -1) {
            System.out.println("该编号可以使用");
            drugs = Arrays.copyOf(drugs,drugs.length+1);
            System.out.println("输入想要创建的药品【药品名称】:");
            String drugName = sc.next();
            System.out.println("输入想要创建的药品【产地】:");
            String placeOfOrigin = sc.next();
            System.out.println("输入想要创建的药品【进价】:");
            double purchasingPrice = sc.nextDouble();
            System.out.println("输入想要创建的药品【单价】:");
            double unitPrice = sc.nextDouble();
            System.out.println("输入想要创建的药品【库存】:");
            int quantityInStock = sc.nextInt();
            drugs[drugs.length-1] = new Drug(
                strDrugNum, drugName, placeOfOrigin, purchasingPrice, unitPrice, quantityInStock);
            System.out.println("创建完毕");
            return drugs;
        
        }
        else{
            System.out.println("非法输入或该药品编号已存在");
        }
        return drugs;
    }
    public static Drug[] dropDrugInformaction(Drug[]drugs){
        System.out.println("输入待删除的目标ID:");
        Scanner sc = new Scanner(System.in);
        String strDrugNum = sc.next();
        int i = cheakInputDrugNumAndReturnIndex(strDrugNum, drugs);
        if (i == -2) {
            return drugs;
        }else if (i == -1) {
            System.out.println("系统内无此药物");
        }else{
            drugs[i] = drugs[drugs.length-1];
            drugs = Arrays.copyOf(drugs, drugs.length-1);
            System.out.println("该药物已删除");
        }
        return drugs;
    }
    static public void retrieveDrug(Drug[] drugs){
        System.out.println("输入待查找的目标ID:");
        Scanner sc = new Scanner(System.in);
        String strDrugNum = sc.next();
        int i = cheakInputDrugNumAndReturnIndex(strDrugNum, drugs);
        if (i == -2) {
            return;
        }else if (i == -1) {
            System.out.println("系统内无此药物");
        }else{
            System.out.println("药品编号 | 药品名称 | 产地 | 进价 | 单价 | 库存");
            System.out.println(drugs[i].drugNumber+" | "+drugs[i].drugName+" | "+drugs[i].placeOfOrigin+" | "+drugs[i].purchasingPrice+" | "+drugs[i].unitPrice+" | "+drugs[i].quantityInStock);
        }
    }

    public static void main(String[] args) {
        DrugManagementSystem.drugs = initDrugs(DrugManagementSystem.strDrugsInformaction);
        while (true) {
            menu();
        }
    }
    public static void unitPrice(Drug[]drugs){
        System.out.println("售价最高的药品信息为：");
        System.out.println("药品编号 | 药品名称 | 产地 | 进价 | 单价 | 库存");
        double purcasingPriceMax = 0;
        for(int i = 0;i<drugs.length;i++){
            purcasingPriceMax = Math.max(purcasingPriceMax, drugs[i].unitPrice);
        }
        for(Drug i : drugs){
            if (purcasingPriceMax==i.unitPrice) {
                System.out.println(i.drugNumber+" | "+i.drugName+" | "+i.placeOfOrigin+" | "+i.purchasingPrice+" | "+i.unitPrice+" | "+i.quantityInStock);
            }
        }
    }
    public static void showPurcasingPriceMoreThanThatAndPlaceOfOrigInThere(){
        System.out.println("进价高于15元且在南京生产的药品信息为:");
        System.out.println("药品编号 | 药品名称 | 产地 | 进价 | 单价 | 库存");
        for(Drug i : drugs){
            if (i.purchasingPrice > 15 && i.placeOfOrigin.equals("南京")) {
                System.out.println(i.drugNumber+" | "+i.drugName+" | "+i.placeOfOrigin+" | "+i.purchasingPrice+" | "+i.unitPrice+" | "+i.quantityInStock);
            }
        }
    }
    static public Drug[] bubbleSort(Drug[] drugs) {
        for (int i = 0; i < drugs.length - 1; i++) {
            for (int j = 0; j < drugs.length - 1 - i; j++) {
                Drug temp = null;
                if (drugs[j].purchasingPrice > drugs[j + 1].purchasingPrice) {
                    temp = drugs[j];
                    drugs[j] = drugs[j + 1];
                    drugs[j + 1] = temp;
                }
            }
        }
        return drugs;
    }
    public static void showPlaceOfOriginAndNum(Drug[]drugs){
        int i = 0;
        int j = 0;
        String[] placeOfOriginTypesArray = new String[0];
        int [] placeOfOriginNumArray = new int[0];
        //我用信息表做外层，类型表做内层
        for(j = 0;j<drugs.length;j++){
            boolean flag = false;
            //逐个比对类型表，检查是否存在该类型，我给它i是为了把i传出去
            for(i = 0;i<placeOfOriginTypesArray.length;i++){
                if (drugs[j].placeOfOrigin.equals(placeOfOriginTypesArray[i])) {
                    placeOfOriginNumArray[i]+=1;
                    flag = true;
                    break;
                }         
            }
            if (!flag) {
                placeOfOriginNumArray = Arrays.copyOf(placeOfOriginNumArray, placeOfOriginNumArray.length+1);
                placeOfOriginTypesArray = Arrays.copyOf(placeOfOriginTypesArray, placeOfOriginTypesArray.length+1);

                placeOfOriginTypesArray[placeOfOriginTypesArray.length-1] = drugs[j].placeOfOrigin;
                placeOfOriginNumArray[placeOfOriginNumArray.length-1] = 1;
            }
        }
        for(int l =0;l<placeOfOriginTypesArray.length;l++){
            System.out.println(Arrays.toString(placeOfOriginTypesArray));
            System.out.println("生产地在："+placeOfOriginTypesArray[l]+" 的的药品总共有： "+placeOfOriginNumArray[l]+" 种,详情如下：");
            System.out.println("药品编号 | 药品名称 | 产地 | 进价 | 单价 | 库存");
            for(Drug ii:drugs){
                if (ii.placeOfOrigin.equals(placeOfOriginTypesArray[l])) {
                    System.out.println(ii.drugNumber+" | "+ii.drugName+" | "+ii.placeOfOrigin+" | "+ii.purchasingPrice+" | "+ii.unitPrice+" | "+ii.quantityInStock);
            }
            }
        }
    }
    static public void getPlaceOfOriginASP(Drug[]drugs){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入想要查询的地区：");
        String tempPlanceOfOrigin = sc.next();
        double tempSum = 0;
        int tempNum = 0;
        for(int i=0;i<drugs.length;i++){
            if (drugs[i].placeOfOrigin.equals(tempPlanceOfOrigin)) {
                tempNum++;
                tempSum += drugs[i].unitPrice;
            }
        }
        if (tempNum==0) {
            System.out.println("系统未收录该地区药物");
        }else{
            System.out.println(tempPlanceOfOrigin+" 地区的药品平均售价为： "+tempSum/tempNum);
        }
    }
}
/**
 * drug
 */
class Drug {
    String drugNumber = null;    //药品编号
    String drugName = null;  //药品名称
    String placeOfOrigin = null;   //产地
    double purchasingPrice = 0;     //进价
    double unitPrice = 0;     //单价
    int quantityInStock = 0;       //库存数量

    Drug(String drugNumber,String drugName,String placeOfOrigin,double purchasingPrice,double unitPrice,int quantityInStock){
        this.drugNumber = drugNumber;
        this.drugName = drugName;
        this.placeOfOrigin = placeOfOrigin;
        this.purchasingPrice = purchasingPrice;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }
    void setUnitPric(){
        Scanner sc = new Scanner(System.in);
        unitPrice = sc.nextDouble();
    }
    void setQuantityInStock(){
        Scanner sc = new Scanner(System.in);
        quantityInStock = sc.nextInt();
    }
    void setplaceOfOrigin(){
        Scanner sc = new Scanner(System.in);
        placeOfOrigin = sc.next();
    }
}
