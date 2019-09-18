package frame;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-31
 */

import com.mr.contact.dao.Dao;
import com.mr.contact.dao.DaoFactory;
import com.mr.contact.swing.CustomerFrame;
import com.mr.contact.swing.FixedTable;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import pojo.Communication;
import pojo.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 展示客户详细信息窗体
 */
public class ShowInfoFrame extends CustomerFrame{
    private Dao dao;//数据库接口
    private MainFrame frame;//父窗体
    private Customer cust;//要展示信息的客户
    private FixedTable table;//通信信息表格
    private JTextField nameText;//姓名输入框
    private JTextField workUnitText;//工作单位输入框
    private JTextField roleText;//职位输入框
    private JTextField workAddressText;//工作地点输入框
    private JTextField homeText;//家庭住址输入框
    private JTextField birthText;//生日输入框
    private JTextField sexText;//性别输入框
    private DefaultTableModel tableModel;//通信信息表格数据模型

    public ShowInfoFrame(Customer cust,JFrame frame) {
        //调用父类创建"展示"窗体的构造方法
        super(frame,CustomerFrame.SHOW);
        this.cust = cust;
        this.frame = (MainFrame) frame;
        setTitle("详细信息");
        dao = DaoFactory.getDao();
        table = getTable();
        table.setCellEditable(false);

        tableModel = getTableModel();
        initTableModel();

        nameText =  getNameText();
        nameText.setText(cust.getName());

        sexText = getSexText();
        sexText.setText(cust.getSex());

        birthText = getBirthText();
        if (null != cust.getBirth()){
            birthText.setText(cust.getBirth());
        }

        workUnitText = getWorkUnitText();
        if (null != cust.getWork_unit()) {
            workUnitText.setText(cust.getWork_unit());
        }

        roleText = getRoleText();
        if (null != cust.getRole()){
            roleText.setText(cust.getRole());
        }

        workAddressText = getWorkAddressText();
        if (null != cust.getWork_addr()){
            workAddressText.setText(cust.getWork_addr());
        }

        homeText = getHomeText();
        if (null != cust.getHome_addr()){
            homeText.setText(cust.getHome_addr());
        }

        FlowLayout btnPanelLayout = new FlowLayout(FlowLayout.RIGHT);
        JPanel btnPanel = new JPanel(btnPanelLayout);
        getContentPane().add(btnPanel,BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("关闭");
        btnPanel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void initTableModel() {
        if (tableModel.getRowCount() > 0){
            tableModel.getDataVector().clear();
            tableModel.fireTableDataChanged();
        }

        List<Communication> usableList = dao.selectCustmerCommunicationUsable(cust);

        String[] tableValues = new String[5];
        for (Communication com : usableList) {
            if (com.getAvailable().endsWith("Y")){
                tableValues[0] = "" + com.getId();
                tableValues[1] = "" + com.getOffice_phone();
                tableValues[2] = "" + com.getMobile_phone();
                tableValues[3] = "" + com.getEmail();
                tableValues[4] = "" + com.getQq();
                tableModel.addRow(tableValues);
            }
        }
    }


}
