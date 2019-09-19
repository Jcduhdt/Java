package frame;

import com.mr.contact.dao.Dao;
import com.mr.contact.dao.DaoFactory;
import com.mr.contact.swing.ContactFrame;
import com.mr.contact.swing.FixedTable;
import pojo.Customer;
import pojo.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-31
 */
public class MainFrame extends ContactFrame {
    private Dao dao;//数据库接口
    private FixedTable table;//通讯录表格
    private DefaultTableModel tableModel;//定义表格模型对象模型
    static private User user;//当前登录用户  记录用户身份
    private JButton update_btn;//修改按钮
    private JButton add_btn;//添加按钮
    private JButton del_btn;//删除按钮

    public MainFrame() {
        setTitle("通讯录系统");
        init();//组件初始化
        validate();//重新加载组件
        addAction();
    }

    /**
     * 添加组件监听
     */
    private void addAction() {
        table.addMouseListener(new MouseAdapter() {// 表格添加鼠标事件监听
            public void mouseClicked(MouseEvent e) {// 当鼠标点击时
                if (e.getClickCount() == 2) {// 如果鼠标是双击事件
                    // 获得选中行的第一列数据，赋值为id
                    String id = (String) table.getValueAt(table.getSelectedRow(), 0);
                    // 获取此id的持久化客户信息对象
                    Customer cust = dao.selectCustomer(Integer.parseInt(id));
                    cust.setId(Integer.parseInt(id));// 将id值转成int值并赋给客户对象
                    // 打开详细信息展示窗体
                    ShowInfoFrame info = new ShowInfoFrame(cust, MainFrame.this);
                    info.setVisible(true);// 窗体可见
                } // if结束
            }// mouseClicked()结束
        });// addMouseListener()结束
        update_btn.addActionListener(new ActionListener() {//更新按钮添加动作事件监听
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowindex = table.getSelectedRow();//获取当前表格选中的行索引
                if (rowindex > -1){//如果有选中的值
                    //获取表格第一列的值作为id
                    String id = (String) table.getValueAt(rowindex,0);
                    //获取数据库中与此id相同的客户数据
                    Customer update = dao.selectCustomer(Integer.parseInt(id));
                    //创建客户修改窗体
                    UpdateCustomerFrame show = new UpdateCustomerFrame(update,MainFrame.this);
                    show.setVisible(true);//设置窗体可见
                }
            }
        });

        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建添加客户窗体
                AddCustomerFrame add = new AddCustomerFrame(MainFrame.this);
                add.setVisible(true);//窗体可见
            }
        });

        del_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowindex = table.getSelectedRow();//获取当前表格选中的行索引
                if (rowindex > -1){//如果有选中的值
                    //弹出提示对话框，提示客户名字，获取用户操作返回的结果
                    int i = JOptionPane.showConfirmDialog(MainFrame.this,
                            "确认是否删除"+table.getValueAt(rowindex,1)+"?",
                            "注意！",JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION){//如果选择yes
                        Customer del = new Customer();//创建客户对象
                        String id = (String) table.getValueAt(rowindex,0);//获取被删除的客户id
                        del.setId(Integer.parseInt(id));//设置客户id
                        dao.deleteCustomer(del,user);//将客户信息删除
                        tableModel.removeRow(table.getSelectedRow());//删除表格中被选中的行
                    }
                }
            }
        });
    }// addAction()j结束


    /**
     * 组件初始化
     */
    protected void init() {
        super.init();										// 调用父类init()方法
        dao = DaoFactory.getDao();							// 实例化数据库接口
        table = getTable();									// 创建指定表格模型的表格
        table.setCellEditable(false);							// 让表格不可编辑
        initTable();											// 初始化表格数据
        update_btn = new JButton("修改");
        add_btn = new JButton("添加");
        del_btn = new JButton("删除");
        if (user.getStatus().equals(User.ADMIN)){//如果是管理员身份
            JPanel bottomPanel = new JPanel();//创建底部按钮面板
            FlowLayout bottomLayout = new FlowLayout();//创建流布局
            bottomLayout.setHgap(20);//横间距为20像素
            bottomLayout.setAlignment(FlowLayout.RIGHT);//右对齐
            bottomPanel.setLayout(bottomLayout);//载入流布局
            bottomPanel.add(add_btn);//添加按钮放入底部面板
            bottomPanel.add(update_btn);//底部面板添加修改按钮
            bottomPanel.add(del_btn);//底部面板添加删除按钮
            getContentPane().add(bottomPanel,BorderLayout.SOUTH);//将底部面板放到主容器最南位置
        }
    }// init()结束

    /**
     * 初始化表格数据
     */
    public void initTable() {
        tableModel = getUsableModleSoure();					// 获取所有有效客户信息
        table.setModel(tableModel);							// 客户信息表格加载数据模型
    }// initTable()

    /**
     * 查询所有有效客户信息
     *
     * @return表格数据模型
     */
    private DefaultTableModel getUsableModleSoure() {
        List<Customer> usableList = dao.selectUsableCustomer();	// 获取所有有效客户
        return assembledModleSoure(usableList);				// 返回有所有有效客户表格数据模型
    }// getUsableModleSoure()结束

    /**
     * 根据不同的客户集合，获取相应的表格数据模型
     *
     * @param usableList -客户集合
     * @return表格数据模型
     */
    private DefaultTableModel assembledModleSoure(List<Customer> usableList) {
        int customerCount = usableList.size();					// 获取集合的客户数量
        String[] columnNames = { "编号", "姓名", "性别", "出生日期", "工作单位","职位",
                "工作地点", "家庭住址" };		// 定义表格列名数组
        String[][] tableValues = new String[customerCount][8];	// 创建表格数据数组
        //似乎就每列的属性值已经是在table那固定了
        for (int i = 0; i<customerCount; i++) {					// 遍历表格所有行
            Customer cust = usableList.get(i);				// 获取行用户对象
            tableValues[i][0] = "" + cust.getId();				// 第一列为编号
            tableValues[i][1] = cust.getName();				// 第二列为名称
            tableValues[i][2] = cust.getSex();				// 第三列为性别
            tableValues[i][3] = cust.getBirth();				// 第四列为出生日期
            tableValues[i][4] = cust.getWork_unit();			// 第五列为公司名称
            tableValues[i][5] = cust.getRole();				// 第六位为职位
            tableValues[i][6] = cust.getWork_addr();			// 第七列为公司地址
            tableValues[i][7] = cust.getHome_addr();			// 第八列为家庭住址
        } // for结束
        // 根据列名数组和数据数组创建表格数据模型
        //传递的tableValues是已经是二维数组的形式了，columnNames就是每列的属性名
        DefaultTableModel tmp = new DefaultTableModel(tableValues, columnNames);
        return tmp;
    }// assembledModleSoure()结束

    /**
     * 获取当前操作用户
     */
    static public User getUser() {
        return user;
    }// getUser()结束

    /**
     * 设置当前操作用户
     *
     * @param user-当前操作用户
     */
    static public void setUser(User user) {
        MainFrame.user = user;
    }// setUser()结束

}
