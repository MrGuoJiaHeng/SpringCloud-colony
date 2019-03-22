import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


public class JobApplicationTests {

    @Test
    public void contextLoads() {
        String dir = System.getProperty("user.dir") + "\\src\\main\\java";
        GlobalConfig globalConfig = new GlobalConfig();
        //设置是否覆盖上一次的文件
        globalConfig.setFileOverride(true);
        //设置是否支持AR模式
        globalConfig.setActiveRecord(true);
        //设置生成位置
        globalConfig.setOutputDir(dir);
        //设置生成作者
        globalConfig.setAuthor("郭家恒");
        //设置主键生成策略
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setServiceName("%sService");
        //设置通用mapperxml
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/easybuy?serverTimezone=GMT%2B8&characterEncoding=utf8")
                .setUsername("root").setPassword("123");

        //设置生成配置策略
        StrategyConfig stConfig = new StrategyConfig();
        //设置生成下划线
        stConfig.setNaming(NamingStrategy.underline_to_camel);
        stConfig.setCapitalMode(true);
//        stConfig.setTablePrefix("pwf_");
//        stConfig.setInclude("smbms_address","smbms_bill","smbms_provider","smbms_role","smbms_user");
        stConfig.setInclude("easybuy_product");
        PackageConfig pg = new PackageConfig();
        pg.setParent("com.gd.entity");
        pg.setEntity("entity");

        AutoGenerator ag = new AutoGenerator();
        ag.setPackageInfo(pg);
        ag.setDataSource(dsConfig);
        ag.setGlobalConfig(globalConfig);
        ag.setStrategy(stConfig);
        ag.execute();

    }

}

