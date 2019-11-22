package view;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import modal.bean.ConsultaDes;
import modal.dao.BDBMM;
import modal.dao.DesmatamentoDao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class TelaConsulta extends javax.swing.JInternalFrame {

    public static TelaConsulta instancia = null;
    private final String amazonia = "<html>O bioma Amazônia compreende uma área na qual se encontra a maior floresta tropical do mundo. A Floresta Amazônica estende-se por nove países da América do Sul, sendo sua maior porção localizada no Brasil, ocupando cerca de 40% do território. É o maior de todos os biomas brasileiros. Caracteriza-se pela presença de diversos ecossistemas e por deter grande biodiversidade na fauna e na flora. Esse bioma compreende uma região constituída pela maior bacia hidrográfica do mundo: a Bacia Amazônica.</html>";
    private final String caatinga = "<html>O bioma Caatinga compreende cerca de 11% do território brasileiro, ocupando boa parte da Região Nordeste até a porção norte de Minas Gerais. O nome dado a esse bioma tem origem indígena e significa “floresta branca”, denominação que remete às características dessa vegetação ao longo da estação seca. Considerado o bioma mais seco, a Caatinga apresenta baixos índices pluviométricos.</html>";
    private final String cerrado = "<html>O Cerrado é considerado o segundo maior bioma da América Latina e do Brasil. Conhecido como savana brasileira, apresenta grande biodiversidade e compreende uma área de elevado potencial aquífero. Esse bioma caracteriza-se por apresentar diversas fitofisionomias em virtude dos vários contatos geográficos que possui com outros biomas. Ao norte, limita-se com o bioma Amazônia; a leste e ao nordeste, com a Caatinga; ao sudoeste, com o Pantanal; e a sudeste, com a Mata Atlântica.</html>";
    private final String mataAtlantica = "<html>O bioma Mata Atlântica ocupa cerca de 13% do território brasileiro e compreende a região costeira do Brasil, indo dos estados do Rio Grande do Norte ao Rio Grande do Sul. Esse bioma é composto por variados ecossistemas florestais e por uma biodiversidade semelhante à do bioma Amazônia. Hoje resta menos de 10% da mata nativa, que sofre com o intenso desmatamento, responsável pela extinção de diversas espécies desse bioma.</html>";
    private final String pampa = "<html>O bioma Pampa, conhecido também como Campos Sulinos, ocupa cerca de 2% do território brasileiro, abrangendo o território do estado do Rio Grande do Sul. O nome “pampa” tem origem indígena e designa uma região plana. A paisagem desse bioma é composta, em sua maioria, por campos nativos. O Pampa apresenta grande biodiversidade.</html>";
    private final String pantanal = "<html>O bioma Pantanal é considerado uma das maiores planícies alagadas do mundo, compreendendo os estados do Mato Grosso e Mato Grosso do Sul. É o menor bioma em extensão territorial do Brasil, ocupando cerca de 2% do território nacional. É um bioma com grande biodiversidade, que vem sendo ameaçada pela ação antrópica. Esse bioma sofre influência de outros biomas, como Amazônia, Cerrado e Mata Atlântica.</html>";
    private String bioma, de, ate;
    private final int qntEstado = 27;
    private final String[] estado = new String[qntEstado];
    private final JTable[] tabEstado = new JTable[qntEstado];
    private final DefaultTableModel[] tabelaEstado = new DefaultTableModel[qntEstado];
    private final DefaultCategoryDataset[] modGraficos = new DefaultCategoryDataset[qntEstado];
    private final JFreeChart[] graficos = new JFreeChart[qntEstado];
    private final ChartPanel[] graficoBarra = new ChartPanel[qntEstado];
    private final ImageIcon icone = new ImageIcon("images//logo-bmm.png");

    public TelaConsulta() {
        initComponents();
        instancia = this;
        tabEstados.setEnabled(false);
        scrollTbGeral.setVisible(false);
        btnGeraRelatorio.setVisible(false);
        lbInfRelatorio.setVisible(false);

        defineEstadoETabelas();
        addItens();
        trataFechamento();
        tempoReal();
    }

    private void trataFechamento() {
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                instancia = null;
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
    }

    public void centralizaTela() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void addItens() {
        BDBMM bd = new BDBMM();
        bd.addItem("SELECT DISTINCT nome_bioma FROM bioma", "nome_bioma", cboConBioma);
        bd.addItem("SELECT ano FROM ano", "ano", cboDe);
        bd.addItem("SELECT ano FROM ano", "ano", cboAte);
    }

    private void tempoReal() {
        ActionListener verificacao = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                introBioma();
            }
        };

        cboConBioma.addActionListener(verificacao);
    }

    private void defineEstadoETabelas() {
        estado[0] = "AC";
        estado[1] = "AL";
        estado[2] = "AP";
        estado[3] = "AM";
        estado[4] = "BA";
        estado[5] = "CE";
        estado[6] = "ES";
        estado[7] = "GO";
        estado[8] = "MA";
        estado[9] = "MT";
        estado[10] = "MS";
        estado[11] = "MG";
        estado[12] = "PA";
        estado[13] = "PB";
        estado[14] = "PR";
        estado[15] = "PE";
        estado[16] = "PI";
        estado[17] = "RJ";
        estado[18] = "RN";
        estado[19] = "RS";
        estado[20] = "RO";
        estado[21] = "RR";
        estado[22] = "SC";
        estado[23] = "SP";
        estado[24] = "SE";
        estado[25] = "TO";

        tabelaEstado[0] = (DefaultTableModel) tbAcre.getModel();
        tabelaEstado[1] = (DefaultTableModel) tbAlagoas.getModel();
        tabelaEstado[2] = (DefaultTableModel) tbAmapa.getModel();
        tabelaEstado[3] = (DefaultTableModel) tbAmazonas.getModel();
        tabelaEstado[4] = (DefaultTableModel) tbBahia.getModel();
        tabelaEstado[5] = (DefaultTableModel) tbCeara.getModel();
        tabelaEstado[6] = (DefaultTableModel) tbEspiritoSanto.getModel();
        tabelaEstado[7] = (DefaultTableModel) tbGoias.getModel();
        tabelaEstado[8] = (DefaultTableModel) tbMaranhao.getModel();
        tabelaEstado[9] = (DefaultTableModel) tbMatoGrosso.getModel();
        tabelaEstado[10] = (DefaultTableModel) tbMatoGrossodoSul.getModel();
        tabelaEstado[11] = (DefaultTableModel) tbMinasGerais.getModel();
        tabelaEstado[12] = (DefaultTableModel) tbPara.getModel();
        tabelaEstado[13] = (DefaultTableModel) tbParaiba.getModel();
        tabelaEstado[14] = (DefaultTableModel) tbParana.getModel();
        tabelaEstado[15] = (DefaultTableModel) tbPernambuco.getModel();
        tabelaEstado[16] = (DefaultTableModel) tbPiaui.getModel();
        tabelaEstado[17] = (DefaultTableModel) tbRiodeJaneiro.getModel();
        tabelaEstado[18] = (DefaultTableModel) tbRioGrandedoNorte.getModel();
        tabelaEstado[19] = (DefaultTableModel) tbRioGrandedoSul.getModel();
        tabelaEstado[20] = (DefaultTableModel) tbRondonia.getModel();
        tabelaEstado[21] = (DefaultTableModel) tbRoraima.getModel();
        tabelaEstado[22] = (DefaultTableModel) tbSantaCatarina.getModel();
        tabelaEstado[23] = (DefaultTableModel) tbSaoPaulo.getModel();
        tabelaEstado[24] = (DefaultTableModel) tbSergipe.getModel();
        tabelaEstado[25] = (DefaultTableModel) tbTocantins.getModel();
        tabelaEstado[26] = (DefaultTableModel) tbGeral.getModel();

        tabEstado[0] = tbAcre;
        tabEstado[1] = tbAlagoas;
        tabEstado[2] = tbAmapa;
        tabEstado[3] = tbAmazonas;
        tabEstado[4] = tbBahia;
        tabEstado[5] = tbCeara;
        tabEstado[6] = tbEspiritoSanto;
        tabEstado[7] = tbGoias;
        tabEstado[8] = tbMaranhao;
        tabEstado[9] = tbMatoGrosso;
        tabEstado[10] = tbMatoGrossodoSul;
        tabEstado[11] = tbMinasGerais;
        tabEstado[12] = tbPara;
        tabEstado[13] = tbParaiba;
        tabEstado[14] = tbParana;
        tabEstado[15] = tbPernambuco;
        tabEstado[16] = tbPiaui;
        tabEstado[17] = tbRiodeJaneiro;
        tabEstado[18] = tbRioGrandedoNorte;
        tabEstado[19] = tbRioGrandedoSul;
        tabEstado[20] = tbRondonia;
        tabEstado[21] = tbRoraima;
        tabEstado[22] = tbSantaCatarina;
        tabEstado[23] = tbSaoPaulo;
        tabEstado[24] = tbSergipe;
        tabEstado[25] = tbTocantins;
        tabEstado[26] = tbGeral;
    }

    private void introBioma() {
        int selecao = cboConBioma.getSelectedIndex();
        switch (selecao) {
            case 0:
                lbIntroBioma.setText(amazonia);
                break;
            case 1:
                lbIntroBioma.setText(caatinga);
                break;
            case 2:
                lbIntroBioma.setText(cerrado);
                break;
            case 3:
                lbIntroBioma.setText(mataAtlantica);
                break;
            case 4:
                lbIntroBioma.setText(pampa);
                break;
            case 5:
                lbIntroBioma.setText(pantanal);
                break;
            default:
                break;
        }
    }

    private void addGraficoPainel(JPanel painel, ChartPanel grafico) {
        grafico.setBounds(0, 0, painel.getWidth(), painel.getHeight());
        painel.removeAll();
        painel.add(grafico, BorderLayout.CENTER);
        painel.validate();
    }

    private void desativaAbas(String bioma) {
        if (bioma.equals("Amazônia")) {

            tabEstados.setEnabledAt(1, true);
            tabEstados.setEnabledAt(2, false);
            tabEstados.setEnabledAt(3, true);
            tabEstados.setEnabledAt(4, true);
            tabEstados.setEnabledAt(5, false);
            tabEstados.setEnabledAt(6, false);
            tabEstados.setEnabledAt(7, false);
            tabEstados.setEnabledAt(8, false);
            tabEstados.setEnabledAt(9, true);
            tabEstados.setEnabledAt(10, true);
            tabEstados.setEnabledAt(11, false);
            tabEstados.setEnabledAt(12, false);
            tabEstados.setEnabledAt(13, true);
            tabEstados.setEnabledAt(14, false);
            tabEstados.setEnabledAt(15, false);
            tabEstados.setEnabledAt(16, false);
            tabEstados.setEnabledAt(17, false);
            tabEstados.setEnabledAt(18, false);
            tabEstados.setEnabledAt(19, false);
            tabEstados.setEnabledAt(20, false);
            tabEstados.setEnabledAt(21, true);
            tabEstados.setEnabledAt(22, true);
            tabEstados.setEnabledAt(23, false);
            tabEstados.setEnabledAt(24, false);
            tabEstados.setEnabledAt(25, false);
            tabEstados.setEnabledAt(26, true);

        } else if (bioma.equals("Caatinga")) {

            tabEstados.setEnabledAt(1, false);
            tabEstados.setEnabledAt(2, true);
            tabEstados.setEnabledAt(3, false);
            tabEstados.setEnabledAt(4, false);
            tabEstados.setEnabledAt(5, true);
            tabEstados.setEnabledAt(6, true);
            tabEstados.setEnabledAt(7, false);
            tabEstados.setEnabledAt(8, false);
            tabEstados.setEnabledAt(9, false);
            tabEstados.setEnabledAt(10, false);
            tabEstados.setEnabledAt(11, false);
            tabEstados.setEnabledAt(12, true);
            tabEstados.setEnabledAt(13, false);
            tabEstados.setEnabledAt(14, true);
            tabEstados.setEnabledAt(15, false);
            tabEstados.setEnabledAt(16, true);
            tabEstados.setEnabledAt(17, true);
            tabEstados.setEnabledAt(18, false);
            tabEstados.setEnabledAt(19, true);
            tabEstados.setEnabledAt(20, false);
            tabEstados.setEnabledAt(21, false);
            tabEstados.setEnabledAt(22, false);
            tabEstados.setEnabledAt(23, false);
            tabEstados.setEnabledAt(24, false);
            tabEstados.setEnabledAt(25, true);
            tabEstados.setEnabledAt(26, false);

        } else if (bioma.equals("Cerrado")) {

            tabEstados.setEnabledAt(1, false);
            tabEstados.setEnabledAt(2, false);
            tabEstados.setEnabledAt(3, false);
            tabEstados.setEnabledAt(4, false);
            tabEstados.setEnabledAt(5, true);
            tabEstados.setEnabledAt(6, false);
            tabEstados.setEnabledAt(7, false);
            tabEstados.setEnabledAt(8, true);
            tabEstados.setEnabledAt(9, true);
            tabEstados.setEnabledAt(10, true);
            tabEstados.setEnabledAt(11, true);
            tabEstados.setEnabledAt(12, true);
            tabEstados.setEnabledAt(13, false);
            tabEstados.setEnabledAt(14, false);
            tabEstados.setEnabledAt(15, true);
            tabEstados.setEnabledAt(16, false);
            tabEstados.setEnabledAt(17, true);
            tabEstados.setEnabledAt(18, false);
            tabEstados.setEnabledAt(19, false);
            tabEstados.setEnabledAt(20, false);
            tabEstados.setEnabledAt(21, false);
            tabEstados.setEnabledAt(22, false);
            tabEstados.setEnabledAt(23, false);
            tabEstados.setEnabledAt(24, true);
            tabEstados.setEnabledAt(25, false);
            tabEstados.setEnabledAt(26, true);

        } else if (bioma.equals("Mata Atlântica")) {

            tabEstados.setEnabledAt(1, false);
            tabEstados.setEnabledAt(2, true);
            tabEstados.setEnabledAt(3, false);
            tabEstados.setEnabledAt(4, false);
            tabEstados.setEnabledAt(5, true);
            tabEstados.setEnabledAt(6, false);
            tabEstados.setEnabledAt(7, true);
            tabEstados.setEnabledAt(8, true);
            tabEstados.setEnabledAt(9, false);
            tabEstados.setEnabledAt(10, false);
            tabEstados.setEnabledAt(11, true);
            tabEstados.setEnabledAt(12, true);
            tabEstados.setEnabledAt(13, false);
            tabEstados.setEnabledAt(14, true);
            tabEstados.setEnabledAt(15, true);
            tabEstados.setEnabledAt(16, true);
            tabEstados.setEnabledAt(17, false);
            tabEstados.setEnabledAt(18, true);
            tabEstados.setEnabledAt(19, true);
            tabEstados.setEnabledAt(20, true);
            tabEstados.setEnabledAt(21, false);
            tabEstados.setEnabledAt(22, false);
            tabEstados.setEnabledAt(23, true);
            tabEstados.setEnabledAt(24, true);
            tabEstados.setEnabledAt(25, true);
            tabEstados.setEnabledAt(26, false);

        } else if (bioma.equals("Pampa")) {

            tabEstados.setEnabledAt(1, false);
            tabEstados.setEnabledAt(2, false);
            tabEstados.setEnabledAt(3, false);
            tabEstados.setEnabledAt(4, false);
            tabEstados.setEnabledAt(5, false);
            tabEstados.setEnabledAt(6, false);
            tabEstados.setEnabledAt(7, false);
            tabEstados.setEnabledAt(8, false);
            tabEstados.setEnabledAt(9, false);
            tabEstados.setEnabledAt(10, false);
            tabEstados.setEnabledAt(11, false);
            tabEstados.setEnabledAt(12, false);
            tabEstados.setEnabledAt(13, false);
            tabEstados.setEnabledAt(14, false);
            tabEstados.setEnabledAt(15, false);
            tabEstados.setEnabledAt(16, false);
            tabEstados.setEnabledAt(17, false);
            tabEstados.setEnabledAt(18, false);
            tabEstados.setEnabledAt(19, false);
            tabEstados.setEnabledAt(20, true);
            tabEstados.setEnabledAt(21, false);
            tabEstados.setEnabledAt(22, false);
            tabEstados.setEnabledAt(23, false);
            tabEstados.setEnabledAt(24, false);
            tabEstados.setEnabledAt(25, false);
            tabEstados.setEnabledAt(26, false);

        } else if (bioma.equals("Pantanal")) {

            tabEstados.setEnabledAt(1, false);
            tabEstados.setEnabledAt(2, false);
            tabEstados.setEnabledAt(3, false);
            tabEstados.setEnabledAt(4, false);
            tabEstados.setEnabledAt(5, false);
            tabEstados.setEnabledAt(6, false);
            tabEstados.setEnabledAt(7, false);
            tabEstados.setEnabledAt(8, false);
            tabEstados.setEnabledAt(9, false);
            tabEstados.setEnabledAt(10, true);
            tabEstados.setEnabledAt(11, true);
            tabEstados.setEnabledAt(12, false);
            tabEstados.setEnabledAt(13, false);
            tabEstados.setEnabledAt(14, false);
            tabEstados.setEnabledAt(15, false);
            tabEstados.setEnabledAt(16, false);
            tabEstados.setEnabledAt(17, false);
            tabEstados.setEnabledAt(18, false);
            tabEstados.setEnabledAt(19, false);
            tabEstados.setEnabledAt(20, false);
            tabEstados.setEnabledAt(21, false);
            tabEstados.setEnabledAt(22, false);
            tabEstados.setEnabledAt(23, false);
            tabEstados.setEnabledAt(24, false);
            tabEstados.setEnabledAt(25, false);
            tabEstados.setEnabledAt(26, false);

        }
    }

    private void geraGrafRelatorio(Document documento, String estado, JFreeChart grafico, JTable tabela) throws IOException, BadElementException, DocumentException {

        documento.newPage();
        Paragraph titulo = new Paragraph();
        Paragraph subTitulo = new Paragraph();
        if (tabela != tbGeral) {
            titulo.add(new Chunk("Dados do estado: " + estado, new Font(FontFamily.UNDEFINED, 18, Font.BOLD)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            documento.add(new Paragraph(" "));
        } else {
            titulo.add(new Chunk("Dados gerais do bioma: " + estado, new Font(FontFamily.UNDEFINED, 18, Font.BOLD)));
            subTitulo.add(new Chunk("Período de " + de + " até " + ate, new Font(FontFamily.UNDEFINED, 15, Font.BOLD)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            subTitulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(subTitulo);
            documento.add(new Paragraph(" "));
        }

        final File arquivo = new File("graficos//" + estado + ".png");
        ChartUtilities.saveChartAsPNG(arquivo, grafico, 700, 350);
        Image imagemGrafico = Image.getInstance("graficos//" + estado + ".png");
        imagemGrafico.scaleToFit(500, 350);
        documento.add(imagemGrafico);
        PdfPTable tabelaPDF = new PdfPTable(tabela.getColumnCount());

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabelaPDF.addCell(tabela.getColumnName(i));
        }
        //pega as informações da tabela e coloca em uma tabela para ser aplicada no arquivo pdf
        for (int rows = 0; rows < tabela.getRowCount(); rows++) {
            for (int cols = 0; cols < tabela.getColumnCount(); cols++) {
                tabelaPDF.addCell(tabela.getModel().getValueAt(rows, cols).toString());
            }
        }
        documento.add(tabelaPDF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pInfConsulta = new javax.swing.JPanel();
        lbBioma = new javax.swing.JLabel();
        cboConBioma = new javax.swing.JComboBox<>();
        btnUpConfirma = new javax.swing.JButton();
        lbIntroBioma = new javax.swing.JLabel();
        btnUpConfirma1 = new javax.swing.JButton();
        lbBioma1 = new javax.swing.JLabel();
        cboDe = new javax.swing.JComboBox<>();
        cboAte = new javax.swing.JComboBox<>();
        lbBioma3 = new javax.swing.JLabel();
        lbIntroducao = new javax.swing.JLabel();
        pAreaGraficos = new javax.swing.JPanel();
        tabEstados = new javax.swing.JTabbedPane();
        pGeral = new javax.swing.JPanel();
        pGrafGeral = new javax.swing.JPanel();
        scrollTbGeral = new javax.swing.JScrollPane();
        tbGeral = new javax.swing.JTable();
        btnGeraRelatorio = new javax.swing.JButton();
        lbInfRelatorio = new javax.swing.JLabel();
        pAcre = new javax.swing.JPanel();
        pGrafAcre = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcre = new javax.swing.JTable();
        pAlagoas = new javax.swing.JPanel();
        pGrafAlagoas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAlagoas = new javax.swing.JTable();
        pAmapa = new javax.swing.JPanel();
        pGrafAmapa = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbAmapa = new javax.swing.JTable();
        pAmazonas = new javax.swing.JPanel();
        pGrafAmazonas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbAmazonas = new javax.swing.JTable();
        pBahia = new javax.swing.JPanel();
        pGrafBahia = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbBahia = new javax.swing.JTable();
        pCeara = new javax.swing.JPanel();
        pGrafCeara = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbCeara = new javax.swing.JTable();
        pEspiritoSanto = new javax.swing.JPanel();
        pGrafEspiritoSanto = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbEspiritoSanto = new javax.swing.JTable();
        pGoias = new javax.swing.JPanel();
        pGrafGoias = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbGoias = new javax.swing.JTable();
        pMaranhao = new javax.swing.JPanel();
        pGrafMaranhao = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbMaranhao = new javax.swing.JTable();
        pMatoGrosso = new javax.swing.JPanel();
        pGrafMatoGrosso = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbMatoGrosso = new javax.swing.JTable();
        pMatoGrossodoSul = new javax.swing.JPanel();
        pGrafMatoGrossodoSul = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbMatoGrossodoSul = new javax.swing.JTable();
        pMinasGerais = new javax.swing.JPanel();
        pGrafMinasGerais = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbMinasGerais = new javax.swing.JTable();
        pPara = new javax.swing.JPanel();
        pGrafPara = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbPara = new javax.swing.JTable();
        pParaiba = new javax.swing.JPanel();
        pGrafParaiba = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbParaiba = new javax.swing.JTable();
        pParana = new javax.swing.JPanel();
        pGrafParana = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tbParana = new javax.swing.JTable();
        pPernambuco = new javax.swing.JPanel();
        pGrafPernambuco = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbPernambuco = new javax.swing.JTable();
        pPiaui = new javax.swing.JPanel();
        pGrafPiaui = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tbPiaui = new javax.swing.JTable();
        pRiodeJaneiro = new javax.swing.JPanel();
        pGrafRiodeJaneiro = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tbRiodeJaneiro = new javax.swing.JTable();
        pRioGrandedoNorte = new javax.swing.JPanel();
        pGrafRioGrandedoNorte = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tbRioGrandedoNorte = new javax.swing.JTable();
        pRioGrandedoSul = new javax.swing.JPanel();
        pGrafRioGrandedoSul = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbRioGrandedoSul = new javax.swing.JTable();
        pRondonia = new javax.swing.JPanel();
        pGrafRondonia = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tbRondonia = new javax.swing.JTable();
        pRoraima = new javax.swing.JPanel();
        pGrafRoraima = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbRoraima = new javax.swing.JTable();
        pSantaCatarina = new javax.swing.JPanel();
        pGrafSantaCatarina = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tbSantaCatarina = new javax.swing.JTable();
        pSaoPaulo = new javax.swing.JPanel();
        pGrafSaoPaulo = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbSaoPaulo = new javax.swing.JTable();
        pSergipe = new javax.swing.JPanel();
        pGrafSergipe = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbSergipe = new javax.swing.JTable();
        pTocantins = new javax.swing.JPanel();
        pGrafTocantins = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        tbTocantins = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Relatório de Desmatamento");
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        pInfConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações de Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N
        pInfConsulta.setMaximumSize(new java.awt.Dimension(255, 570));
        pInfConsulta.setMinimumSize(new java.awt.Dimension(255, 570));
        pInfConsulta.setPreferredSize(new java.awt.Dimension(255, 570));

        lbBioma.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBioma.setText("Bioma:");

        btnUpConfirma.setText("Consultar");
        btnUpConfirma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpConfirma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulta(evt);
            }
        });

        lbIntroBioma.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbIntroBioma.setText("<html>O bioma Amazônia compreende uma área na qual se encontra a maior floresta tropical do mundo. A Floresta Amazônica estende-se por nove países da América do Sul, sendo sua maior porção localizada no Brasil, ocupando cerca de 40% do território. É o maior de todos os biomas brasileiros. Caracteriza-se pela presença de diversos ecossistemas e por deter grande biodiversidade na fauna e na flora. Esse bioma compreende uma região constituída pela maior bacia hidrográfica do mundo: a Bacia Amazônica.</html>");
        lbIntroBioma.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnUpConfirma1.setText("Saiba Mais!");
        btnUpConfirma1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpConfirma1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpConfirma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saibaMais(evt);
            }
        });

        lbBioma1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBioma1.setText("De:");

        cboDe.setPreferredSize(new java.awt.Dimension(65, 28));

        cboAte.setPreferredSize(new java.awt.Dimension(65, 28));

        lbBioma3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBioma3.setText("/  Até:");

        lbIntroducao.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbIntroducao.setText("Introdução:");

        javax.swing.GroupLayout pInfConsultaLayout = new javax.swing.GroupLayout(pInfConsulta);
        pInfConsulta.setLayout(pInfConsultaLayout);
        pInfConsultaLayout.setHorizontalGroup(
            pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfConsultaLayout.createSequentialGroup()
                .addGroup(pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInfConsultaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnUpConfirma1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInfConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIntroBioma, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInfConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUpConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInfConsultaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbBioma1)
                            .addComponent(lbBioma))
                        .addGap(10, 10, 10)
                        .addGroup(pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pInfConsultaLayout.createSequentialGroup()
                                .addComponent(cboDe, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbBioma3)
                                .addGap(10, 10, 10)
                                .addComponent(cboAte, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboConBioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pInfConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIntroducao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pInfConsultaLayout.setVerticalGroup(
            pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBioma)
                    .addComponent(cboConBioma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pInfConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBioma1)
                    .addComponent(cboDe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBioma3)
                    .addComponent(cboAte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIntroducao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIntroBioma, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpConfirma1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pAreaGraficos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gráficos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N
        pAreaGraficos.setMaximumSize(new java.awt.Dimension(730, 570));
        pAreaGraficos.setMinimumSize(new java.awt.Dimension(730, 570));
        pAreaGraficos.setPreferredSize(new java.awt.Dimension(730, 570));

        tabEstados.setMaximumSize(new java.awt.Dimension(718, 529));
        tabEstados.setMinimumSize(new java.awt.Dimension(718, 529));

        javax.swing.GroupLayout pGrafGeralLayout = new javax.swing.GroupLayout(pGrafGeral);
        pGrafGeral.setLayout(pGrafGeralLayout);
        pGrafGeralLayout.setHorizontalGroup(
            pGrafGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pGrafGeralLayout.setVerticalGroup(
            pGrafGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        scrollTbGeral.setMaximumSize(new java.awt.Dimension(32767, 165));
        scrollTbGeral.setPreferredSize(new java.awt.Dimension(452, 165));

        tbGeral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbGeral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbGeral.getTableHeader().setReorderingAllowed(false);
        scrollTbGeral.setViewportView(tbGeral);
        if (tbGeral.getColumnModel().getColumnCount() > 0) {
            tbGeral.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        btnGeraRelatorio.setText("Gerar Relatório");
        btnGeraRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGeraRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geraRelatorio(evt);
            }
        });

        lbInfRelatorio.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        lbInfRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbInfRelatorio.setText("<html><center>\nGere um relatório completo com todos os dados referente a este bioma clicando no botão abaixo.\n</html>");
        lbInfRelatorio.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pGeralLayout = new javax.swing.GroupLayout(pGeral);
        pGeral.setLayout(pGeralLayout);
        pGeralLayout.setHorizontalGroup(
            pGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pGeralLayout.createSequentialGroup()
                        .addComponent(pGrafGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pGeralLayout.createSequentialGroup()
                        .addComponent(scrollTbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(pGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbInfRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pGeralLayout.createSequentialGroup()
                                .addComponent(btnGeraRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)))
                        .addGap(49, 49, 49))))
        );
        pGeralLayout.setVerticalGroup(
            pGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pGeralLayout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(lbInfRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGeraRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addComponent(scrollTbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabEstados.addTab("Geral", pGeral);

        javax.swing.GroupLayout pGrafAcreLayout = new javax.swing.GroupLayout(pGrafAcre);
        pGrafAcre.setLayout(pGrafAcreLayout);
        pGrafAcreLayout.setHorizontalGroup(
            pGrafAcreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafAcreLayout.setVerticalGroup(
            pGrafAcreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbAcre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbAcre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAcre.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbAcre);
        if (tbAcre.getColumnModel().getColumnCount() > 0) {
            tbAcre.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pAcreLayout = new javax.swing.GroupLayout(pAcre);
        pAcre.setLayout(pAcreLayout);
        pAcreLayout.setHorizontalGroup(
            pAcreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAcreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAcreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafAcre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        pAcreLayout.setVerticalGroup(
            pAcreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAcreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafAcre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Acre", pAcre);

        javax.swing.GroupLayout pGrafAlagoasLayout = new javax.swing.GroupLayout(pGrafAlagoas);
        pGrafAlagoas.setLayout(pGrafAlagoasLayout);
        pGrafAlagoasLayout.setHorizontalGroup(
            pGrafAlagoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafAlagoasLayout.setVerticalGroup(
            pGrafAlagoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbAlagoas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbAlagoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAlagoas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbAlagoas);
        if (tbAlagoas.getColumnModel().getColumnCount() > 0) {
            tbAlagoas.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pAlagoasLayout = new javax.swing.GroupLayout(pAlagoas);
        pAlagoas.setLayout(pAlagoasLayout);
        pAlagoasLayout.setHorizontalGroup(
            pAlagoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAlagoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAlagoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafAlagoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        pAlagoasLayout.setVerticalGroup(
            pAlagoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAlagoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafAlagoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Alagoas", pAlagoas);

        javax.swing.GroupLayout pGrafAmapaLayout = new javax.swing.GroupLayout(pGrafAmapa);
        pGrafAmapa.setLayout(pGrafAmapaLayout);
        pGrafAmapaLayout.setHorizontalGroup(
            pGrafAmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafAmapaLayout.setVerticalGroup(
            pGrafAmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbAmapa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbAmapa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAmapa.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbAmapa);
        if (tbAmapa.getColumnModel().getColumnCount() > 0) {
            tbAmapa.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pAmapaLayout = new javax.swing.GroupLayout(pAmapa);
        pAmapa.setLayout(pAmapaLayout);
        pAmapaLayout.setHorizontalGroup(
            pAmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAmapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafAmapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        pAmapaLayout.setVerticalGroup(
            pAmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAmapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafAmapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Amapá", pAmapa);

        javax.swing.GroupLayout pGrafAmazonasLayout = new javax.swing.GroupLayout(pGrafAmazonas);
        pGrafAmazonas.setLayout(pGrafAmazonasLayout);
        pGrafAmazonasLayout.setHorizontalGroup(
            pGrafAmazonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafAmazonasLayout.setVerticalGroup(
            pGrafAmazonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbAmazonas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbAmazonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAmazonas.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tbAmazonas);
        if (tbAmazonas.getColumnModel().getColumnCount() > 0) {
            tbAmazonas.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pAmazonasLayout = new javax.swing.GroupLayout(pAmazonas);
        pAmazonas.setLayout(pAmazonasLayout);
        pAmazonasLayout.setHorizontalGroup(
            pAmazonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAmazonasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAmazonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafAmazonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        pAmazonasLayout.setVerticalGroup(
            pAmazonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAmazonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafAmazonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Amazonas", pAmazonas);

        javax.swing.GroupLayout pGrafBahiaLayout = new javax.swing.GroupLayout(pGrafBahia);
        pGrafBahia.setLayout(pGrafBahiaLayout);
        pGrafBahiaLayout.setHorizontalGroup(
            pGrafBahiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafBahiaLayout.setVerticalGroup(
            pGrafBahiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbBahia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbBahia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBahia.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbBahia);
        if (tbBahia.getColumnModel().getColumnCount() > 0) {
            tbBahia.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pBahiaLayout = new javax.swing.GroupLayout(pBahia);
        pBahia.setLayout(pBahiaLayout);
        pBahiaLayout.setHorizontalGroup(
            pBahiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBahiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBahiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafBahia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        pBahiaLayout.setVerticalGroup(
            pBahiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBahiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafBahia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Bahia", pBahia);

        javax.swing.GroupLayout pGrafCearaLayout = new javax.swing.GroupLayout(pGrafCeara);
        pGrafCeara.setLayout(pGrafCearaLayout);
        pGrafCearaLayout.setHorizontalGroup(
            pGrafCearaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafCearaLayout.setVerticalGroup(
            pGrafCearaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbCeara.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbCeara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCeara.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tbCeara);
        if (tbCeara.getColumnModel().getColumnCount() > 0) {
            tbCeara.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pCearaLayout = new javax.swing.GroupLayout(pCeara);
        pCeara.setLayout(pCearaLayout);
        pCearaLayout.setHorizontalGroup(
            pCearaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCearaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCearaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafCeara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        pCearaLayout.setVerticalGroup(
            pCearaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCearaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafCeara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Ceará", pCeara);

        javax.swing.GroupLayout pGrafEspiritoSantoLayout = new javax.swing.GroupLayout(pGrafEspiritoSanto);
        pGrafEspiritoSanto.setLayout(pGrafEspiritoSantoLayout);
        pGrafEspiritoSantoLayout.setHorizontalGroup(
            pGrafEspiritoSantoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafEspiritoSantoLayout.setVerticalGroup(
            pGrafEspiritoSantoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbEspiritoSanto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbEspiritoSanto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEspiritoSanto.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tbEspiritoSanto);
        if (tbEspiritoSanto.getColumnModel().getColumnCount() > 0) {
            tbEspiritoSanto.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pEspiritoSantoLayout = new javax.swing.GroupLayout(pEspiritoSanto);
        pEspiritoSanto.setLayout(pEspiritoSantoLayout);
        pEspiritoSantoLayout.setHorizontalGroup(
            pEspiritoSantoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspiritoSantoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEspiritoSantoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafEspiritoSanto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        pEspiritoSantoLayout.setVerticalGroup(
            pEspiritoSantoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEspiritoSantoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafEspiritoSanto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Espírito Santo", pEspiritoSanto);

        javax.swing.GroupLayout pGrafGoiasLayout = new javax.swing.GroupLayout(pGrafGoias);
        pGrafGoias.setLayout(pGrafGoiasLayout);
        pGrafGoiasLayout.setHorizontalGroup(
            pGrafGoiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafGoiasLayout.setVerticalGroup(
            pGrafGoiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbGoias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbGoias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbGoias.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tbGoias);
        if (tbGoias.getColumnModel().getColumnCount() > 0) {
            tbGoias.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pGoiasLayout = new javax.swing.GroupLayout(pGoias);
        pGoias.setLayout(pGoiasLayout);
        pGoiasLayout.setHorizontalGroup(
            pGoiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pGoiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGoiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafGoias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        pGoiasLayout.setVerticalGroup(
            pGoiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGoiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafGoias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Goiás", pGoias);

        javax.swing.GroupLayout pGrafMaranhaoLayout = new javax.swing.GroupLayout(pGrafMaranhao);
        pGrafMaranhao.setLayout(pGrafMaranhaoLayout);
        pGrafMaranhaoLayout.setHorizontalGroup(
            pGrafMaranhaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafMaranhaoLayout.setVerticalGroup(
            pGrafMaranhaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbMaranhao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbMaranhao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMaranhao.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tbMaranhao);
        if (tbMaranhao.getColumnModel().getColumnCount() > 0) {
            tbMaranhao.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pMaranhaoLayout = new javax.swing.GroupLayout(pMaranhao);
        pMaranhao.setLayout(pMaranhaoLayout);
        pMaranhaoLayout.setHorizontalGroup(
            pMaranhaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMaranhaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMaranhaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafMaranhao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );
        pMaranhaoLayout.setVerticalGroup(
            pMaranhaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMaranhaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafMaranhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Maranhão", pMaranhao);

        javax.swing.GroupLayout pGrafMatoGrossoLayout = new javax.swing.GroupLayout(pGrafMatoGrosso);
        pGrafMatoGrosso.setLayout(pGrafMatoGrossoLayout);
        pGrafMatoGrossoLayout.setHorizontalGroup(
            pGrafMatoGrossoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafMatoGrossoLayout.setVerticalGroup(
            pGrafMatoGrossoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbMatoGrosso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbMatoGrosso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMatoGrosso.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tbMatoGrosso);
        if (tbMatoGrosso.getColumnModel().getColumnCount() > 0) {
            tbMatoGrosso.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pMatoGrossoLayout = new javax.swing.GroupLayout(pMatoGrosso);
        pMatoGrosso.setLayout(pMatoGrossoLayout);
        pMatoGrossoLayout.setHorizontalGroup(
            pMatoGrossoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMatoGrossoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMatoGrossoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafMatoGrosso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        pMatoGrossoLayout.setVerticalGroup(
            pMatoGrossoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMatoGrossoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafMatoGrosso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Mato Grosso", pMatoGrosso);

        javax.swing.GroupLayout pGrafMatoGrossodoSulLayout = new javax.swing.GroupLayout(pGrafMatoGrossodoSul);
        pGrafMatoGrossodoSul.setLayout(pGrafMatoGrossodoSulLayout);
        pGrafMatoGrossodoSulLayout.setHorizontalGroup(
            pGrafMatoGrossodoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafMatoGrossodoSulLayout.setVerticalGroup(
            pGrafMatoGrossodoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbMatoGrossodoSul.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbMatoGrossodoSul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMatoGrossodoSul.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(tbMatoGrossodoSul);
        if (tbMatoGrossodoSul.getColumnModel().getColumnCount() > 0) {
            tbMatoGrossodoSul.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pMatoGrossodoSulLayout = new javax.swing.GroupLayout(pMatoGrossodoSul);
        pMatoGrossodoSul.setLayout(pMatoGrossodoSulLayout);
        pMatoGrossodoSulLayout.setHorizontalGroup(
            pMatoGrossodoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMatoGrossodoSulLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMatoGrossodoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafMatoGrossodoSul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );
        pMatoGrossodoSulLayout.setVerticalGroup(
            pMatoGrossodoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMatoGrossodoSulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafMatoGrossodoSul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Mato Grosso do Sul", pMatoGrossodoSul);

        javax.swing.GroupLayout pGrafMinasGeraisLayout = new javax.swing.GroupLayout(pGrafMinasGerais);
        pGrafMinasGerais.setLayout(pGrafMinasGeraisLayout);
        pGrafMinasGeraisLayout.setHorizontalGroup(
            pGrafMinasGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafMinasGeraisLayout.setVerticalGroup(
            pGrafMinasGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbMinasGerais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbMinasGerais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMinasGerais.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tbMinasGerais);
        if (tbMinasGerais.getColumnModel().getColumnCount() > 0) {
            tbMinasGerais.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pMinasGeraisLayout = new javax.swing.GroupLayout(pMinasGerais);
        pMinasGerais.setLayout(pMinasGeraisLayout);
        pMinasGeraisLayout.setHorizontalGroup(
            pMinasGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMinasGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMinasGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafMinasGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane13))
                .addContainerGap())
        );
        pMinasGeraisLayout.setVerticalGroup(
            pMinasGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMinasGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafMinasGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Minas Gerais", pMinasGerais);

        javax.swing.GroupLayout pGrafParaLayout = new javax.swing.GroupLayout(pGrafPara);
        pGrafPara.setLayout(pGrafParaLayout);
        pGrafParaLayout.setHorizontalGroup(
            pGrafParaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafParaLayout.setVerticalGroup(
            pGrafParaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbPara.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbPara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPara.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(tbPara);
        if (tbPara.getColumnModel().getColumnCount() > 0) {
            tbPara.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pParaLayout = new javax.swing.GroupLayout(pPara);
        pPara.setLayout(pParaLayout);
        pParaLayout.setHorizontalGroup(
            pParaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pParaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pParaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafPara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane14))
                .addContainerGap())
        );
        pParaLayout.setVerticalGroup(
            pParaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pParaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Pará", pPara);

        javax.swing.GroupLayout pGrafParaibaLayout = new javax.swing.GroupLayout(pGrafParaiba);
        pGrafParaiba.setLayout(pGrafParaibaLayout);
        pGrafParaibaLayout.setHorizontalGroup(
            pGrafParaibaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafParaibaLayout.setVerticalGroup(
            pGrafParaibaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbParaiba.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbParaiba.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbParaiba.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(tbParaiba);
        if (tbParaiba.getColumnModel().getColumnCount() > 0) {
            tbParaiba.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pParaibaLayout = new javax.swing.GroupLayout(pParaiba);
        pParaiba.setLayout(pParaibaLayout);
        pParaibaLayout.setHorizontalGroup(
            pParaibaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pParaibaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pParaibaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafParaiba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15))
                .addContainerGap())
        );
        pParaibaLayout.setVerticalGroup(
            pParaibaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pParaibaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafParaiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Paraíba", pParaiba);

        javax.swing.GroupLayout pGrafParanaLayout = new javax.swing.GroupLayout(pGrafParana);
        pGrafParana.setLayout(pGrafParanaLayout);
        pGrafParanaLayout.setHorizontalGroup(
            pGrafParanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafParanaLayout.setVerticalGroup(
            pGrafParanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbParana.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbParana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbParana.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(tbParana);
        if (tbParana.getColumnModel().getColumnCount() > 0) {
            tbParana.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pParanaLayout = new javax.swing.GroupLayout(pParana);
        pParana.setLayout(pParanaLayout);
        pParanaLayout.setHorizontalGroup(
            pParanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pParanaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pParanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafParana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane16))
                .addContainerGap())
        );
        pParanaLayout.setVerticalGroup(
            pParanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pParanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafParana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Paraná", pParana);

        javax.swing.GroupLayout pGrafPernambucoLayout = new javax.swing.GroupLayout(pGrafPernambuco);
        pGrafPernambuco.setLayout(pGrafPernambucoLayout);
        pGrafPernambucoLayout.setHorizontalGroup(
            pGrafPernambucoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafPernambucoLayout.setVerticalGroup(
            pGrafPernambucoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbPernambuco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbPernambuco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPernambuco.getTableHeader().setReorderingAllowed(false);
        jScrollPane17.setViewportView(tbPernambuco);
        if (tbPernambuco.getColumnModel().getColumnCount() > 0) {
            tbPernambuco.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pPernambucoLayout = new javax.swing.GroupLayout(pPernambuco);
        pPernambuco.setLayout(pPernambucoLayout);
        pPernambucoLayout.setHorizontalGroup(
            pPernambucoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPernambucoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPernambucoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafPernambuco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane17))
                .addContainerGap())
        );
        pPernambucoLayout.setVerticalGroup(
            pPernambucoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPernambucoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafPernambuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Pernambuco", pPernambuco);

        javax.swing.GroupLayout pGrafPiauiLayout = new javax.swing.GroupLayout(pGrafPiaui);
        pGrafPiaui.setLayout(pGrafPiauiLayout);
        pGrafPiauiLayout.setHorizontalGroup(
            pGrafPiauiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafPiauiLayout.setVerticalGroup(
            pGrafPiauiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbPiaui.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbPiaui.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPiaui.getTableHeader().setReorderingAllowed(false);
        jScrollPane18.setViewportView(tbPiaui);
        if (tbPiaui.getColumnModel().getColumnCount() > 0) {
            tbPiaui.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pPiauiLayout = new javax.swing.GroupLayout(pPiaui);
        pPiaui.setLayout(pPiauiLayout);
        pPiauiLayout.setHorizontalGroup(
            pPiauiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPiauiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPiauiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafPiaui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane18))
                .addContainerGap())
        );
        pPiauiLayout.setVerticalGroup(
            pPiauiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPiauiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafPiaui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Piauí", pPiaui);

        javax.swing.GroupLayout pGrafRiodeJaneiroLayout = new javax.swing.GroupLayout(pGrafRiodeJaneiro);
        pGrafRiodeJaneiro.setLayout(pGrafRiodeJaneiroLayout);
        pGrafRiodeJaneiroLayout.setHorizontalGroup(
            pGrafRiodeJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafRiodeJaneiroLayout.setVerticalGroup(
            pGrafRiodeJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbRiodeJaneiro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbRiodeJaneiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRiodeJaneiro.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(tbRiodeJaneiro);
        if (tbRiodeJaneiro.getColumnModel().getColumnCount() > 0) {
            tbRiodeJaneiro.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pRiodeJaneiroLayout = new javax.swing.GroupLayout(pRiodeJaneiro);
        pRiodeJaneiro.setLayout(pRiodeJaneiroLayout);
        pRiodeJaneiroLayout.setHorizontalGroup(
            pRiodeJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRiodeJaneiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRiodeJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafRiodeJaneiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane19))
                .addContainerGap())
        );
        pRiodeJaneiroLayout.setVerticalGroup(
            pRiodeJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRiodeJaneiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafRiodeJaneiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Rio de Janeiro", pRiodeJaneiro);

        javax.swing.GroupLayout pGrafRioGrandedoNorteLayout = new javax.swing.GroupLayout(pGrafRioGrandedoNorte);
        pGrafRioGrandedoNorte.setLayout(pGrafRioGrandedoNorteLayout);
        pGrafRioGrandedoNorteLayout.setHorizontalGroup(
            pGrafRioGrandedoNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafRioGrandedoNorteLayout.setVerticalGroup(
            pGrafRioGrandedoNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbRioGrandedoNorte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbRioGrandedoNorte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRioGrandedoNorte.getTableHeader().setReorderingAllowed(false);
        jScrollPane20.setViewportView(tbRioGrandedoNorte);
        if (tbRioGrandedoNorte.getColumnModel().getColumnCount() > 0) {
            tbRioGrandedoNorte.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pRioGrandedoNorteLayout = new javax.swing.GroupLayout(pRioGrandedoNorte);
        pRioGrandedoNorte.setLayout(pRioGrandedoNorteLayout);
        pRioGrandedoNorteLayout.setHorizontalGroup(
            pRioGrandedoNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRioGrandedoNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRioGrandedoNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafRioGrandedoNorte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane20))
                .addContainerGap())
        );
        pRioGrandedoNorteLayout.setVerticalGroup(
            pRioGrandedoNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRioGrandedoNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafRioGrandedoNorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Rio Grande do Norte", pRioGrandedoNorte);

        javax.swing.GroupLayout pGrafRioGrandedoSulLayout = new javax.swing.GroupLayout(pGrafRioGrandedoSul);
        pGrafRioGrandedoSul.setLayout(pGrafRioGrandedoSulLayout);
        pGrafRioGrandedoSulLayout.setHorizontalGroup(
            pGrafRioGrandedoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafRioGrandedoSulLayout.setVerticalGroup(
            pGrafRioGrandedoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbRioGrandedoSul.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbRioGrandedoSul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRioGrandedoSul.getTableHeader().setReorderingAllowed(false);
        jScrollPane21.setViewportView(tbRioGrandedoSul);
        if (tbRioGrandedoSul.getColumnModel().getColumnCount() > 0) {
            tbRioGrandedoSul.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pRioGrandedoSulLayout = new javax.swing.GroupLayout(pRioGrandedoSul);
        pRioGrandedoSul.setLayout(pRioGrandedoSulLayout);
        pRioGrandedoSulLayout.setHorizontalGroup(
            pRioGrandedoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRioGrandedoSulLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRioGrandedoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafRioGrandedoSul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane21))
                .addContainerGap())
        );
        pRioGrandedoSulLayout.setVerticalGroup(
            pRioGrandedoSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRioGrandedoSulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafRioGrandedoSul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Rio Grande do Sul", pRioGrandedoSul);

        javax.swing.GroupLayout pGrafRondoniaLayout = new javax.swing.GroupLayout(pGrafRondonia);
        pGrafRondonia.setLayout(pGrafRondoniaLayout);
        pGrafRondoniaLayout.setHorizontalGroup(
            pGrafRondoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafRondoniaLayout.setVerticalGroup(
            pGrafRondoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbRondonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbRondonia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRondonia.getTableHeader().setReorderingAllowed(false);
        jScrollPane22.setViewportView(tbRondonia);
        if (tbRondonia.getColumnModel().getColumnCount() > 0) {
            tbRondonia.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pRondoniaLayout = new javax.swing.GroupLayout(pRondonia);
        pRondonia.setLayout(pRondoniaLayout);
        pRondoniaLayout.setHorizontalGroup(
            pRondoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRondoniaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRondoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafRondonia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane22))
                .addContainerGap())
        );
        pRondoniaLayout.setVerticalGroup(
            pRondoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRondoniaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafRondonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Rondônia", pRondonia);

        javax.swing.GroupLayout pGrafRoraimaLayout = new javax.swing.GroupLayout(pGrafRoraima);
        pGrafRoraima.setLayout(pGrafRoraimaLayout);
        pGrafRoraimaLayout.setHorizontalGroup(
            pGrafRoraimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafRoraimaLayout.setVerticalGroup(
            pGrafRoraimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane23.setMaximumSize(new java.awt.Dimension(32767, 145));
        jScrollPane23.setMinimumSize(new java.awt.Dimension(23, 45));
        jScrollPane23.setOpaque(false);
        jScrollPane23.setPreferredSize(new java.awt.Dimension(201, 45));

        tbRoraima.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbRoraima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRoraima.setMinimumSize(new java.awt.Dimension(30, 10));
        tbRoraima.setOpaque(false);
        tbRoraima.getTableHeader().setReorderingAllowed(false);
        jScrollPane23.setViewportView(tbRoraima);
        if (tbRoraima.getColumnModel().getColumnCount() > 0) {
            tbRoraima.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pRoraimaLayout = new javax.swing.GroupLayout(pRoraima);
        pRoraima.setLayout(pRoraimaLayout);
        pRoraimaLayout.setHorizontalGroup(
            pRoraimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRoraimaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRoraimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafRoraima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pRoraimaLayout.setVerticalGroup(
            pRoraimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRoraimaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafRoraima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Roraima", pRoraima);

        javax.swing.GroupLayout pGrafSantaCatarinaLayout = new javax.swing.GroupLayout(pGrafSantaCatarina);
        pGrafSantaCatarina.setLayout(pGrafSantaCatarinaLayout);
        pGrafSantaCatarinaLayout.setHorizontalGroup(
            pGrafSantaCatarinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafSantaCatarinaLayout.setVerticalGroup(
            pGrafSantaCatarinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbSantaCatarina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbSantaCatarina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSantaCatarina.getTableHeader().setReorderingAllowed(false);
        jScrollPane24.setViewportView(tbSantaCatarina);
        if (tbSantaCatarina.getColumnModel().getColumnCount() > 0) {
            tbSantaCatarina.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pSantaCatarinaLayout = new javax.swing.GroupLayout(pSantaCatarina);
        pSantaCatarina.setLayout(pSantaCatarinaLayout);
        pSantaCatarinaLayout.setHorizontalGroup(
            pSantaCatarinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSantaCatarinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSantaCatarinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafSantaCatarina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane24))
                .addContainerGap())
        );
        pSantaCatarinaLayout.setVerticalGroup(
            pSantaCatarinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSantaCatarinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafSantaCatarina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Santa Catarina", pSantaCatarina);

        javax.swing.GroupLayout pGrafSaoPauloLayout = new javax.swing.GroupLayout(pGrafSaoPaulo);
        pGrafSaoPaulo.setLayout(pGrafSaoPauloLayout);
        pGrafSaoPauloLayout.setHorizontalGroup(
            pGrafSaoPauloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafSaoPauloLayout.setVerticalGroup(
            pGrafSaoPauloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbSaoPaulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbSaoPaulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSaoPaulo.getTableHeader().setReorderingAllowed(false);
        jScrollPane25.setViewportView(tbSaoPaulo);
        if (tbSaoPaulo.getColumnModel().getColumnCount() > 0) {
            tbSaoPaulo.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pSaoPauloLayout = new javax.swing.GroupLayout(pSaoPaulo);
        pSaoPaulo.setLayout(pSaoPauloLayout);
        pSaoPauloLayout.setHorizontalGroup(
            pSaoPauloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSaoPauloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSaoPauloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafSaoPaulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane25))
                .addContainerGap())
        );
        pSaoPauloLayout.setVerticalGroup(
            pSaoPauloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaoPauloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafSaoPaulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("São Paulo", pSaoPaulo);

        javax.swing.GroupLayout pGrafSergipeLayout = new javax.swing.GroupLayout(pGrafSergipe);
        pGrafSergipe.setLayout(pGrafSergipeLayout);
        pGrafSergipeLayout.setHorizontalGroup(
            pGrafSergipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafSergipeLayout.setVerticalGroup(
            pGrafSergipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbSergipe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbSergipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSergipe.getTableHeader().setReorderingAllowed(false);
        jScrollPane26.setViewportView(tbSergipe);
        if (tbSergipe.getColumnModel().getColumnCount() > 0) {
            tbSergipe.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pSergipeLayout = new javax.swing.GroupLayout(pSergipe);
        pSergipe.setLayout(pSergipeLayout);
        pSergipeLayout.setHorizontalGroup(
            pSergipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSergipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSergipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafSergipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane26))
                .addContainerGap())
        );
        pSergipeLayout.setVerticalGroup(
            pSergipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSergipeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafSergipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Sergipe", pSergipe);

        javax.swing.GroupLayout pGrafTocantinsLayout = new javax.swing.GroupLayout(pGrafTocantins);
        pGrafTocantins.setLayout(pGrafTocantinsLayout);
        pGrafTocantinsLayout.setHorizontalGroup(
            pGrafTocantinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        pGrafTocantinsLayout.setVerticalGroup(
            pGrafTocantinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbTocantins.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbTocantins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Desmatamento (km²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTocantins.setMaximumSize(new java.awt.Dimension(90, 64));
        tbTocantins.setMinimumSize(new java.awt.Dimension(90, 64));
        tbTocantins.getTableHeader().setReorderingAllowed(false);
        jScrollPane27.setViewportView(tbTocantins);
        if (tbTocantins.getColumnModel().getColumnCount() > 0) {
            tbTocantins.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pTocantinsLayout = new javax.swing.GroupLayout(pTocantins);
        pTocantins.setLayout(pTocantinsLayout);
        pTocantinsLayout.setHorizontalGroup(
            pTocantinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTocantinsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pTocantinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGrafTocantins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane27))
                .addContainerGap())
        );
        pTocantinsLayout.setVerticalGroup(
            pTocantinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTocantinsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafTocantins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabEstados.addTab("Tocantins", pTocantins);

        javax.swing.GroupLayout pAreaGraficosLayout = new javax.swing.GroupLayout(pAreaGraficos);
        pAreaGraficos.setLayout(pAreaGraficosLayout);
        pAreaGraficosLayout.setHorizontalGroup(
            pAreaGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pAreaGraficosLayout.setVerticalGroup(
            pAreaGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabEstados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pInfConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pAreaGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pInfConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addComponent(pAreaGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saibaMais(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saibaMais
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://brasilescola.uol.com.br/brasil/biomas-brasileiros.htm");
            desktop.browse(oURL);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_saibaMais

    private void consulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulta

        if ((Integer.parseInt(cboAte.getSelectedItem().toString()) - Integer.parseInt(cboDe.getSelectedItem().toString())) > 10) {
            JOptionPane.showMessageDialog(null, "Selecione um período máximo de 10 anos!", "Atenção", JOptionPane.INFORMATION_MESSAGE, icone);
        } else if ((Integer.parseInt(cboAte.getSelectedItem().toString()) - Integer.parseInt(cboDe.getSelectedItem().toString())) < 0) {
            JOptionPane.showMessageDialog(null, "O ano final do período deve ser maior que o ano inicial!", "Atenção", JOptionPane.INFORMATION_MESSAGE, icone);
        } else {
            DesmatamentoDao dDao = new DesmatamentoDao();

            for (int i = 0; i < qntEstado - 1; i++) {
                tabelaEstado[i].setNumRows(0);
                for (ConsultaDes des : dDao.consultaDes(estado[i], cboConBioma.getSelectedItem().toString(), cboDe.getSelectedItem().toString(), cboAte.getSelectedItem().toString())) {

                    tabelaEstado[i].addRow(new Object[]{
                        des.getAno(),
                        des.getArea()
                    });
                }

                modGraficos[i] = new DefaultCategoryDataset();

                for (int j = 0; j < tabEstado[i].getRowCount(); j++) {
                    modGraficos[i].setValue((Number) tabEstado[i].getValueAt(j, 1), "Área Desmatada(km²)", (Comparable) tabEstado[i].getValueAt(j, 0));
                }

                graficos[i] = ChartFactory.createBarChart3D("Níveis de Desmatamento de " + estado[i], "Ano", "Área Desmatada(km²)", modGraficos[i], PlotOrientation.VERTICAL, false, true, false);
                graficoBarra[i] = new ChartPanel(graficos[i]);
                add(graficoBarra[i]);

                graficos[i].setBackgroundPaint(new Color(255, 153, 102));
            }
            tabelaEstado[26].setNumRows(0);
            for (ConsultaDes des : dDao.consultaDes(cboConBioma.getSelectedItem().toString(), cboDe.getSelectedItem().toString(), cboAte.getSelectedItem().toString())) {

                tabelaEstado[26].addRow(new Object[]{
                    des.getAno(),
                    des.getArea()
                });

            }
            modGraficos[26] = new DefaultCategoryDataset();
            for (int j = 0; j < tabEstado[26].getRowCount(); j++) {
                modGraficos[26].setValue((Number) tabEstado[26].getValueAt(j, 1), "Área Desmatada(km²)", (Comparable) tabEstado[26].getValueAt(j, 0));
            }
            graficos[26] = ChartFactory.createLineChart3D("Níveis de Desmatamento do Bioma", "Ano", "Área Desmatada(km²)", modGraficos[26], PlotOrientation.VERTICAL, false, true, false);
            graficoBarra[26] = new ChartPanel(graficos[26]);
            add(graficoBarra[26]);
            graficos[26].setBackgroundPaint(new Color(255, 153, 102));

            addGraficoPainel(pGrafAcre, graficoBarra[0]);
            addGraficoPainel(pGrafAlagoas, graficoBarra[1]);
            addGraficoPainel(pGrafAmapa, graficoBarra[2]);
            addGraficoPainel(pGrafAmazonas, graficoBarra[3]);
            addGraficoPainel(pGrafBahia, graficoBarra[4]);
            addGraficoPainel(pGrafCeara, graficoBarra[5]);
            addGraficoPainel(pGrafEspiritoSanto, graficoBarra[6]);
            addGraficoPainel(pGrafGoias, graficoBarra[7]);
            addGraficoPainel(pGrafMaranhao, graficoBarra[8]);
            addGraficoPainel(pGrafMatoGrosso, graficoBarra[9]);
            addGraficoPainel(pGrafMatoGrossodoSul, graficoBarra[10]);
            addGraficoPainel(pGrafMinasGerais, graficoBarra[11]);
            addGraficoPainel(pGrafPara, graficoBarra[12]);
            addGraficoPainel(pGrafParaiba, graficoBarra[13]);
            addGraficoPainel(pGrafParana, graficoBarra[14]);
            addGraficoPainel(pGrafPernambuco, graficoBarra[15]);
            addGraficoPainel(pGrafPiaui, graficoBarra[16]);
            addGraficoPainel(pGrafRiodeJaneiro, graficoBarra[17]);
            addGraficoPainel(pGrafRioGrandedoNorte, graficoBarra[18]);
            addGraficoPainel(pGrafRioGrandedoSul, graficoBarra[19]);
            addGraficoPainel(pGrafRondonia, graficoBarra[20]);
            addGraficoPainel(pGrafRoraima, graficoBarra[21]);
            addGraficoPainel(pGrafSantaCatarina, graficoBarra[22]);
            addGraficoPainel(pGrafSaoPaulo, graficoBarra[23]);
            addGraficoPainel(pGrafSergipe, graficoBarra[24]);
            addGraficoPainel(pGrafTocantins, graficoBarra[25]);
            addGraficoPainel(pGrafGeral, graficoBarra[26]);

            scrollTbGeral.setVisible(true);
            tabEstados.setEnabled(true);
            btnGeraRelatorio.setVisible(true);
            lbInfRelatorio.setVisible(true);
            bioma = cboConBioma.getSelectedItem().toString();
            de = cboDe.getSelectedItem().toString();
            ate = cboAte.getSelectedItem().toString();
            desativaAbas(bioma);
            tabEstados.setSelectedIndex(0);
        }
    }//GEN-LAST:event_consulta

    private void geraRelatorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geraRelatorio

        String nomeArquivo = (String) JOptionPane.showInputDialog(null, "Como você deseja nomear o arquivo?", "Nome do Arquivo", JOptionPane.INFORMATION_MESSAGE, icone, null, null);

        if (nomeArquivo == null) {
        } else if (!nomeArquivo.equals("")) {
            Document documento = new Document();
            try {

                PdfWriter.getInstance(documento, new FileOutputStream("relatorios//" + nomeArquivo + ".pdf"));
                documento.open();
                Paragraph titulo = new Paragraph();
                titulo.add(new Chunk("Relatório de Desmatamento", new Font(FontFamily.UNDEFINED, 24, Font.BOLD)));
                titulo.setAlignment(Element.ALIGN_CENTER);
                documento.add(titulo);
                documento.add(new Paragraph("\n\n       Os gráficos apresentados abaixo visa a facilidade e rapidez "
                        + "com que podemos interpretar os dados, ele aponta a área desmatada em km² e traz as "
                        + "informações sobre a área desmatada de acordo com o estado e período selecionado."
                        + "\n       Com base nessas informações, é possível tomar algumas ações para que o a "
                        + "área desmatada seja cada vez menor, esse mapeamento traz de forma clara e objetiva "
                        + "a real situação do desmatamento por estado, bioma e período."
                        + "\n       Nosso trabalho é disseminar a informação e conscientizar o usuário que"
                        + " pequenas atitudes podem melhorar a flora Brasileira, seja ela com o plantio de "
                        + "arvores ou denúncias sobre o desmatamento ilegal."
                        + "\n       Para denunciar práticas de desmatamento ilegal o telefone gratuito é "
                        + "0800 7041995; também pode ser contatado pelo telefone (61) 3218-2401 ou no site"
                        + " www.agricultura.gov.br."));

                if (bioma.equals("Amazônia")) {

                    geraGrafRelatorio(documento, bioma, graficos[26], tbGeral);
                    documento.add(new Paragraph("\n\n       Este bioma chega ocupar uma área de 4.196.943 Km²,"
                            + " que corresponde mais de 40% do território nacional e é constituída principalmente"
                            + " por uma floresta tropical. A Amazônia passa pelos territórios do Acre, Amapá, "
                            + "Amazonas, Pará e Roraima, e parte do território do Maranhão, Mato Grosso, Rondônia"
                            + " e Tocantins. A Amazônia é formada por distintos ecossistemas como florestas densas "
                            + "de terra firme, florestas estacionais, florestas de igapó, campos alagados, várzeas,"
                            + " savanas, refúgios montanhosos e formações pioneiras."
                            + "\n       Mesmo sendo o nosso bioma mais preservado, cerca de 16% de sua área já foi devastada,"
                            + " o que equivale a duas vezes e meia a área do estado de São Paulo."
                            + "\n       O desmatamento, as queimadas, a garimpagem, o agropastoreio e a biopirataria "
                            + "representam os principais problemas ambientais enfrentados pelo bioma amazônico. O conjunto"
                            + " formado por essas ações devastadoras é responsável por graves mudanças climáticas em todo "
                            + "o planeta, como o aquecimento global."));

                    geraGrafRelatorio(documento, "Acre", graficos[0], tbAcre);
                    documento.add(new Paragraph("\n\n       Se em anos passados o Acre passava quase despercebido na divulgação"
                            + " dos dados do desmatamento na Amazônia Legal, o mesmo não se pode dizer nestes últimos meses. "
                            + "Apesar de ainda apresentar números absolutos baixos, em termos percentuais o estado, "
                            + "agora, ocupa as primeiras posições."
                            + "\n       O crescimento também foi registrado na comparação anual. Entre agosto de 2017 e julho de "
                            + "2018, o desmatamento alcançou a marca de 104 km2; já no período de agosto de 2018 a "
                            + "julho último, o total de floresta destruída chegou a 371 km2 – a variação registrada pelo "
                            + "Imazon é de 257%."
                            + "\n       Em números absolutos, na comparação com os outros estados da Amazônia Legal, o Acre "
                            + "registrou a segunda menor área desmatada. O Pará teve destruídos 1.792 km2 entre agosto "
                            + "de 2018 e julho último."));

                    geraGrafRelatorio(documento, "Amapá", graficos[2], tbAmapa);
                    documento.add(new Paragraph("\n\n       De acordo com a Secretaria de Estado do Meio Ambiente (Sema), "
                            + "73% do território amapaense é composto por unidades de proteção e terras indígenas, locais "
                            + "onde são proibidas derrubadas de madeiras."
                            + "\n       Os números são do Projeto de Monitoramento do Desmatamento na Amazônia Legal por "
                            + "Satélite (Prodes), do Instituto Nacional de Pesquisas Espaciais (Inpe). Apesar do aumento "
                            + "expressivo dentro do Amapá, a quantidade desmatada corresponde a menos de 1% do total "
                            + "da região no período, que foi de 6.624 quilômetros quadrados."
                            + "\n       As informações sobre a perda de mata nativa baseiam-se em imagens de satélites que "
                            + "compõem o Prodes. O estudo avalia as áreas maiores que 6,25 hectares atingidas por corte "
                            + "raso, a modalidade mais nociva, pois ocorre remoção súbita e rápida da vegetação."
                            + "\n       A série histórica de dados mostra a oscilação da quantidade de área desmatada no Amapá, "
                            + "que teve justamente em 2016 o menor registro desde 2004, com 17 quilômetros quadrados. "
                            + "Em 2008 e 2009, o estado apresentou as piores taxas, com 100 e 70 quiômetros quadrados."));

                    geraGrafRelatorio(documento, "Amazonas", graficos[3], tbAmazonas);
                    documento.add(new Paragraph("\n\n       De acordo com a Secretaria de Estado do Meio Ambiente e do Desenvolvimento "
                            + "Sustentável (SDS), os resultados positivos para o Amazonas representam uma agenda "
                            + "intensa de ações de prevenção e controle do desmatamento desenvolvida pelo Governo do "
                            + "Estado e entidades parceiras. Uma das ações mais importantes está no ordenamento "
                            + "territorial e no controle e fiscalização das áreas onde há maior pressão de desmatamento. "
                            + "Essas propostas estão consolidadas no Plano de Prevenção e Controle do Desmatamento do "
                            + "Amazonas."
                            + "\n       Nos últimos cinco anos houve uma redução significativa de 22% do desmatamento ilegal no "
                            + "Amazonas em função das políticas ambientais integradas de prevenção e controle do "
                            + "desmatamento, e do incentivo às atividades produtivas sustentáveis, com foco na agricultura "
                            + "familiar, nas atividades extrativistas e no manejo da pesca pressão de desmatamento. Essas "
                            + "propostas estão consolidadas no Plano de Prevenção e Controle do Desmatamento do "
                            + "Amazonas (PPCD-AM)."));

                    geraGrafRelatorio(documento, "Maranhão", graficos[8], tbMaranhao);
                    documento.add(new Paragraph("\n\n       O Maranhão perdeu 80% da floresta amazônica nos últimos 70 anos."
                            + " A floresta ocupa 1/3 do território estadual e o desmatamento entrou na agenda de discussão "
                            + "no I Workshop sobre a Amazônia Maranhense, em São Luís."
                            + "\n       Das 10 maiores cidades do Maranhão, cinco estão dentro do bioma amazônico. Em todas essas"
                            + " cidades, os estudos indicaram perda da biodiversidade, mudanças relacionadas ao clima "
                            + "e comprometimento na qualidade de vida da população."
                            + "\n       Na parte maranhense da Amazônia Legal, um trabalho de pesquisa para reconhecer as "
                            + "potencialidades e fragilidades nas áreas econômica, social e ambiental envolveu estudantes e "
                            + "pesquisadores do IMESC e UEMA nos últimos seis meses. O zoneamento ecológico do bioma amazônico "
                            + "maranhense confirmou a área como um santuário de biodiversidade que está cada vez mais ameaçada."));

                    geraGrafRelatorio(documento, "Mato Grosso", graficos[9], tbMatoGrosso);
                    documento.add(new Paragraph("\n\n       Mato Grosso tem representação de três biomas brasileiros no seu "
                            + "território. A Amazônia é o mais abrangente, com 480.215 Km2 (53,6%). E esse bioma ocupa a "
                            + "porção norte do estado com vegetação predominantemente florestal (floresta ombrófila, florestas "
                            + "estacionais, campinarana florestada)."
                            + "\n       Contudo, a Amazônia mato-grossense apresenta índices significativos de desmatamento. Cerca "
                            + "de 24% (18/74) dos municípios têm área desmatada acima de 3.000 km2. O mais desmatado é Brasnorte,"
                            + " com mais de 5.000 km2, seguido de Canarana, Juína, Nova Ubiratã e Pontes e Lacerda. Todo o "
                            + "território está inserido no Arco de Desmatamento da Amazônia brasileira, formado pelos estados "
                            + "de Rondônia, norte de Tocantins e sul-sudeste do Pará, além do norte de Mato Grosso."));

                    geraGrafRelatorio(documento, "Pará", graficos[12], tbPara);
                    documento.add(new Paragraph("\n\n       O Pará apresenta um grande índice de desmatamento da Amazônia Legal, "
                            + "de acordo com dados do Boletim do Desmatamento (SAD) do Instituto do Homem e Meio Ambiente da"
                            + " Amazônia(Imazon)."
                            + "\n       O estado teve 37% do total desmatado em toda a Amazônia Legal, que registrou aumento de "
                            + "54% do desmatamento em comparação com janeiro de 2018."
                            + "\n       No total, a Amazônia Legal teve 108 km² desmatados, segundo o Imazon."
                            + "\n       O boletim mostra que, em janeiro deste ano, 67% do desmatamento ocorreu em áreas privadas "
                            + "ou sob diversos estágios de posse. O restante ocorreu em assentamentos - 21%; terras indígenas - 7%; "
                            + "e unidades de conservação - 5%."
                            + "\n       A unidade de conservação mais desflorestada foi a APA Triunfo do Xingu, no Pará. Foram 3 km² "
                            + "de desmatamento. Outras áreas como APA do Tapajós e Resex Verde para Sempre, também no Pará, "
                            + "aparecem no ranking."));

                    geraGrafRelatorio(documento, "Rondônia", graficos[20], tbRondonia);
                    documento.add(new Paragraph("\n\n       Entre os estados amazônicos, Rondônia é o que mais sofreu com o "
                            + "desmatamento. Dados do Instituto do Homem e Meio Ambiente da Amazônia mostram que, entre agosto"
                            + " de 2007 e agosto de 2008, a destruição da floresta aumentou cerca de 23%. Ao todo, 38% da vegetação"
                            + " desapareceram. Depois das áreas particulares, o desmatamento se concentra em unidades de proteção "
                            + "permanente e reservas indígenas."
                            + "\n       Quarenta anos de desmatamento, queimadas, rebanhos ilegais. Em Rondônia, quase metade da "
                            + "Floresta Amazônica foi devastada pelas mãos de garimpeiros, pecuaristas, grileiros. Nem as áreas "
                            + "protegidas – e proibidas – escapam. O cenário é de desolação. A floresta foi cortada e queimada. "
                            + "É quase um deserto. A fazenda está dentro de uma reserva indígena. Quando se olha pela primeira vez,"
                            + " a impressão que se tem é de que no local nunca existiu uma árvore da Amazônia. O que era floresta, "
                            + "virou pasto."
                            + "\n       Na Floresta Nacional do Bom Futuro, há muitas clareiras. O avanço da pecuária desrespeita as "
                            + "regras do plano de uso sustentável da terra. É uma disputa de pelo menos duas décadas."));

                    geraGrafRelatorio(documento, "Roraima", graficos[21], tbRoraima);
                    documento.add(new Paragraph("\n\n       Roraima foi o Estado com o maior avanço do desmatamento da Amazônia em "
                            + "um ano, uma alta de 2700%. É o que indica o Instituto do Homem e Meio Ambiente da Amazônia (Imazon),"
                            + " em relatório divulgado nessa sexta-feira (16). Em julho deste ano, foram 28 quilômetros quadrados, "
                            + "contra apenas um quilômetro quadrado registrado em julho de 2018. O aumento do desmate no Estado "
                            + "pode estar ligado ao avanço do garimpo ilegal, que tem provocado grandes impactos ambientais, de "
                            + "acordo com lideranças indígenas."
                            + "\n       Entre agosto de 2018 e julho de 2019 foram 5.054 quilômetros quadrados de área desmatada, um "
                            + "aumento de 15% em relação ao mesmo período do calendário anterior. A área equivale a quase totalidade"
                            + " do território do Distrito Federal, com 5.760 quilômetros quadrados, segundo números do Instituto "
                            + "Brasileiro de Geografia e Estatística (IBGE)."
                            + "\n       O relatório aponta um crescimento de 66% do desmatamento da Amazônia Legal em julho deste ano,"
                            + " em comparação com o mesmo mês de 2018, um total de 5.054 quilômetros quadrados."));

                    geraGrafRelatorio(documento, "Tocantins", graficos[25], tbTocantins);
                    documento.add(new Paragraph("\n\n       Os alertas de desmatamento no bioma amazônico no Estado do Tocantins "
                            + "caíram 78,5% em 2019 com relação ao ano anterior, de acordo com os alertas parciais emitidos "
                            + "pelo Sistema de Detecção de Desmatamento em Tempo Real (Deter), do Instituto Nacional de Pesquisas "
                            + "Espaciais (Inpe)."
                            + "\n       Os números correspondem ao período de janeiro até 19 de setembro do presente ano, já que o "
                            + "sistema ainda não concluiu o levantamento total do mês, em comparação ao mesmo período de 2018. "
                            + "Os alertas diários emitidos auxiliam no monitoramento e embasamento de ações de fiscalização."
                            + "\n       Os dados apontam que o volume de área de alertas de desmatamento no bioma Amazônia por "
                            + "enquanto é o menor dos últimos três anos no Estado. Em comparação, de janeiro a setembro de 2018 "
                            + "os alertas sinalizaram desmate em 19,12 km² no Tocantins, enquanto no mesmo recorte de tempo em "
                            + "2019 os alertas parciais indicam que 4,1 km² podem estar sob desmate – uma queda de 78,5%."));

                } else if (bioma.equals("Caatinga")) {

                    geraGrafRelatorio(documento, bioma, graficos[26], tbGeral);
                    documento.add(new Paragraph("\n\n       Caatinga é um bioma brasileiro que apresenta clima semiárido, "
                            + "vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade. "
                            + "\n       Esse bioma é encontrado em áreas do Nordeste do Brasil, nos estados do Maranhão, Piauí, Ceará, "
                            + "Rio Grande do Norte, Paraíba, Pernambuco, Alagoas, Sergipe, Bahia e parte de Minas Gerais. Toda "
                            + "essa área abrange cerca de 844 mil km2, ou seja, 11% do território brasileiro."
                            + "\n       O nome Caatinga significa, em tupi-guarani, \"mata branca\". Esse nome faz referência a cor "
                            + "predominante da vegetação durante a estação de seca, onde quase todas as plantas perdem as "
                            + "folhas para diminuir a transpiração e evitar a perda de água armazenada. No inverno, devido a "
                            + "ocorrência de chuva, as folhas verdes e as flores voltam a brotar."
                            + "\n       Apesar de sua importância ecológica, calcula-se que 40 mil km2 da Caatinga já foram "
                            + "transformados em quase deserto, o que é explicado pelo corte da vegetação para servir como "
                            + "lenha e pelo manejo inadequado do solo."));

                    geraGrafRelatorio(documento, "Alagoas", graficos[1], tbAlagoas);
                    documento.add(new Paragraph("\n\n       Um dado alarmante divulgado pelo Instituto Brasileiro de Geografia "
                            + "e Estatística (IBGE) põe Alagoas em uma situação de destaque negativo em todo o País. Segundo o levantamento "
                            + "feito pelo órgão, em 2015 o estado perdeu cerca de 90% de reserva nativa de mata atlântica e "
                            + "82,6% da caatinga. O Ministério do Meio Ambiente informa que a abrangência de cada bioma no "
                            + "estado compreende 14.802 hectares de mata atlântica (52% do total) e 12.995 hectares para a "
                            + "caatinga (48%)."
                            + "\n       Atualmente, restam poucos fragmentos de vegetação nativa, típicos de cada bioma. Em 2010, "
                            + "informações que constam no livro 'Cobertura Vegetal do Estado de Alagoas', produzido pelo Instituto "
                            + "do Meio Ambiente (IMA), em conjunto com a Petrobras, davam conta de que a distribuição da vegetação "
                            + "natural remanescente em Alagoas representava apenas 4.248,96 km², ou seja, 15,28% da área "
                            + "total do estado."));

                    geraGrafRelatorio(documento, "Bahia", graficos[4], tbBahia);
                    documento.add(new Paragraph("\n\n       A Região Semiárida da Bahia, e particularmente o Território de "
                            + "Identidade do Sisal é marcado por graves problemas de ordem socioambiental, como o desmatamento, "
                            + "fruto do avanço da atividade agropecuária, presente na maioria dos seus municípios."
                            + "\n       Sobre o processo do desmatamento da caatinga, alguns autores chamam a atenção para o "
                            + "fato de que a degradação dessa vegetação ocorre de maneira generalizada em todo o Nordeste do "
                            + "Brasil. O Território de Identidade do Sisal, é um exemplo de área onde o bioma caatinga vem sendo "
                            + "paulatinamente substituído pelo cultivo de sisal, pelas pastagens e por outras atividades cujas "
                            + "repercussões socioambientais são crescentes."));

                    geraGrafRelatorio(documento, "Ceará", graficos[5], tbCeara);
                    documento.add(new Paragraph("\n\n       Equipes de fiscalização do Instituto Brasileiro do Meio Ambiente e dos Recursos Naturais "
                            + "Renováveis (Ibama) embargaram 34 propriedades rurais no interior do Ceará e aplicaram mais de "
                            + "R$ 1 milhão em multas pelo desmatamento de áreas do bioma Caatinga."
                            + "\n       Os dados são resultado da Operação Caatinga, que aconteceu entre os dias 19 e 30 de "
                            + "novembro nos municípios de Acopiara, Iguatu, Jucás, Mombaça, Piquet Carneiro, Quixelô e "
                            + "Saboeiro, localizados nos sertões e no sul cearenses."
                            + "\n       As áreas desmatadas sem autorização que foram visitadas pelos fiscais do Ibama na "
                            + "Operação Caatinga somam mais de 800 hectares. Miller conta que apenas uma propriedade teve "
                            + "mais de 150 hectares de área desmatada. “É uma área muito grande para ter vegetação suprimida "
                            + "sem licenciamento”, explica."));

                    geraGrafRelatorio(documento, "Minas Gerais", graficos[11], tbMinasGerais);
                    documento.add(new Paragraph("\n\n       A caatinga está localizada na porção norte do Estado de Minas Gerais e ocupa cerca de 3,48 do "
                            + "território mineiro. É um bioma único no mundo, ou seja, grande parte das espécies de animais e "
                            + "plantas dessa região não é encontrada em nenhum outro lugar do planeta."
                            + "\n       Este patrimônio biológico ainda é pouco estudado e corre grande risco de não ser identificado, "
                            + "devido ao avanço do desmatamento descontrolado. Esse bioma possui como característica duas estações "
                            + ""
                            + "climáticas bem demarcadas, um período chuvoso seguido de um longo período seco."));

                    geraGrafRelatorio(documento, "Paraíba", graficos[13], tbParaiba);
                    documento.add(new Paragraph("\n\n       Além da seca, que já vem afligindo os paraibanos há cinco anos, outro problema ameaça o solo e a "
                            + "vegetação do estado. Só que, desta vez, o processo é irreversível. A Paraíba é o estado brasileiro mais "
                            + "afetado, proporcionalmente, pela desertificação - processo de degradação ambiental que torna as "
                            + "terras inférteis e improdutivas - segundo dados do Instituto Nacional do Semiárido (Insa). Ela é uma "
                            + "consequência das ações humanas e não pode ser revertida - nem com chuva -, apenas desacelerada."
                            + "\n       De acordo com a classificação do Programa de Ação Estadual de Combate à Desertificação e Mitigação "
                            + "dos Efeitos da Seca no Estado da Paraíba (PAE-PB), 93,7% do território do estado está em processo de "
                            + "desertificação, sendo que 58% em nível alto de degradação."));

                    geraGrafRelatorio(documento, "Pernambuco", graficos[15], tbPernambuco);
                    documento.add(new Paragraph("\n\n       A vegetação no domínio natural possui um alto poder calorífico, sendo bastante "
                            + "adequada para a utilização como lenha. Essa característica, associada à grande necessidade "
                            + "energética de uma região que sofre com a falta de investimentos e de presença do Estado, é a "
                            + "principal causa do desmatamento da Caatinga. Estima-se que 30% da energia utilizada pelas "
                            + "indústrias locais advenham dessa prática de extração da lenha da vegetação do semiárido."
                            + "\n       Se considerarmos apenas o estado de Pernambuco, de acordo com dados do Ibama "
                            + "(Instituto Brasileiro do Meio Ambiente e dos Recursos Naturais Renováveis), cerca de 260 mil "
                            + "caminhões com lenha advinda da caatinga são transportados para atender a demanda energética "
                            + "da região. Ainda segundo o órgão, existe certo mito em pensar que a população de baixa renda e "
                            + "os pequenos agricultores são os responsáveis principais pelo desmatamento em questão. "
                            + "Tratase de um problema energético associado à atuação ineficaz do Estado, tanto na permissão de "
                            + "atividades desse tipo quanto na não fiscalização adequada de práticas ilícitas."));

                    geraGrafRelatorio(documento, "Piauí", graficos[16], tbPiaui);
                    documento.add(new Paragraph("\n\n       No Piauí, a caatinga é o bioma predominante, representa 28,4 % da vegetação do "
                            + "território e envolve 63 municípios. O Estado conta com o registro de 932 espécies de animais e "
                            + "20 gêneros de plantas exclusivos da caatinga. Entre eles 44 espécies de lagartos, quatro de "
                            + "quelônios, três de crocodilos, 47 de anfíbios. A diversidade da fauna local também pode ser "
                            + "conferida no número de aves, atualmente já foram registradas 348 espécies, entre elas as aves "
                            + "carcará, anum, jaçanã e gavião turuna entre outros. Atualmente 20 espécies estão ameaçadas de "
                            + "extinção, entre elas a ararinha-azul e a arara-azul-de-lear."
                            + "\n       É importante enfatizar que a caatinga piauiense abriga algumas das mais importantes "
                            + "áreas de preservação deste bioma: o Parque Nacional da Serra da Capivara e a Serra das "
                            + "Confusões localizadas na região sul do Estado."
                            + "\n       Mas infelizmente, assim como outros biomas brasileiros, a Caatinga vem sofrendo "
                            + "ameaças do globo pela exploração predatória. O bioma é rico em "
                            + "espécies exclusivas e podendo ser considerado um dos conjuntos de formações vegetais mais "
                            + "especializadas do território brasileiro."));

                    geraGrafRelatorio(documento, "Rio Grande do Norte", graficos[18], tbRioGrandedoNorte);
                    documento.add(new Paragraph("\n\n       Vegetação exclusivamente brasileira e típica da região Nordeste e do norte de minas gerais, a "
                            + "caatinga possui hoje 53,6% de sua cobertura original, segundo o Instituo Brasileiro do Meio "
                            + "Ambiente e Recursos Renováveis(Ibama), que a partir do monitoramento do desmatamento do "
                            + "bioma feito entre2002 2 2008, revelou ser o Rios Grande do Norte o quinto estado no índice de "
                            + "desmatamento(0,14%), o equivalente a uma área de 1.142 quilômetros quadrados."
                            + "\n       O relatório do Ibama ainda afirma que o RN tem uma área de caatinga de 49.052 Km², "
                            + "dos quais 21.418 Km² foram desmatadas até 2002, considerando-se que área territorial do estado "
                            + "é de 53.077 Km²."
                            + "\n       Já no período de 2002 a 2008, o monitoramento identificou que dois munícipios do "
                            + "Estado estão entre os 20 municípios nordestinos que mais contribuíram com o desmatamento: "
                            + "Mossoró tem uma área de caatinga de 2.110 Km² e desmatou no espaço de sete anos 95 Km², "
                            + "enquanto em Touros a área desmatada foi de 90 Km² de um total de 603 Km²."));

                    geraGrafRelatorio(documento, "Sergipe", graficos[24], tbSergipe);
                    documento.add(new Paragraph("\n\n      Em Sergipe, 42 dos 75 municípios estão totalmente ou parcialmente inseridos no bioma, "
                            + "totalizando uma área de 10.899 km². A caatinga é a tipologia vegetal predominante com 211 mil "
                            + "/hectares (8,5% da vegetação remanescente), aproximadamente 28 municípios em processos de "
                            + "Desertificação."
                            + "\n      Possui apenas 4 unidades de conservação no bioma de caatinga no estado. Em Sergipe, a região "
                            + "semiárida é marcada pela degradação da cobertura florestal e é inevitável deixar de relacioná-la "
                            + "com os modos de produção predominante. Desse modo, destacam-se a disseminação de práticas "
                            + "agrícolas inadequadas, o pastoreio excessivo, o desmatamento, a destruição de áreas com "
                            + "vegetação nativa, o desaparecimento de muitas espécies animais e vegetais, colocando-se em "
                            + "questão a própria capacidade de uso da terra e dos recursos para a manutenção das atividades "
                            + "produtivas e para a garantia de serviços ambientais. Segundo Márcia Rodrigues, 2015, a caatinga "
                            + "em Sergipe tem passado por alterações profundas, com a diminuição da cobertura florestal em "
                            + "18,6% no período compreendido entre 1992 a 2013."));

                } else if (bioma.equals("Cerrado")) {

                    geraGrafRelatorio(documento, bioma, graficos[26], tbGeral);
                    documento.add(new Paragraph("\n\n       O bioma Cerrado é considerado o segundo maior bioma brasileiro em extensão e a mais "
                            + "rica savana do mundo em biodiversidade. "
                            + "Abrange os estados: Amapá, Maranhão, Piauí, Rondônia, Distrito Federal, Goiás, Mato Grosso, "
                            + "Mato Grosso do Sul, Minas Gerais, São Paulo, Tocantins, Bahia. Localiza-se em três das maiores "
                            + "bacias hidrográficas da América do Sul, (Tocantins-Araguaia, São Francisco e Prata) o que, de certa "
                            + "maneira, favorece sua biodiversidade. "
                            + "\n       A vegetação é, em sua maior parte, semelhante à de savana, com árvores baixas, "
                            + "esparsas, troncos retorcidos, folhas grossas e raízes longas; gramíneas e arbustos. "
                            + "\n       O Cerrado é considerado a maior savana do mundo em biodiversidade e compreende "
                            + "grande parte do território brasileiro, uma área de 2 milhões de km². "
                            + "Por isso, o cerrado e os ecossistemas que o compõem possuem uma rica fauna e flora, "
                            + "sendo o habitat de muitas espécies de animais. Este é também um dos motivos deste bioma ser "
                            + "um dos mais afetados pelo tráfico de animais."));

                    geraGrafRelatorio(documento, "Bahia", graficos[4], tbBahia);
                    documento.add(new Paragraph("\n\n       Enquanto o mundo está preocupado com as chamas que avançam sobre a Amazônia, o problema "
                            + "das queimadas na Bahia é com o bioma o Cerrado, de predominância na região oeste, de clima "
                            + "semiárido.\n"
                            + "\n       É nesta região que estão concentrados a maior parte dos focos de incêndio registrados "
                            + "no estado pelo Programa Queimadas, do Instituto Nacional de Pesquisas Espaciais (Inpe), ligado "
                            + "ao Ministério da Ciência e Tecnologia. "
                            + "\n       De acordo com os registros, de 1º de janeiro até esta segunda-feira (26) os satélites do "
                            + "Inpe constataram na Bahia 31.877 focos de incêndio, o que corresponde a 41,7% das ocorrências "
                            + "de 2018, quando houve 76.264 focos. "
                            + "\n       Segundo o Inpe, a relação foco x queimada não é direta nas imagens de satélite. Um foco "
                            + "indica a existência de fogo em um elemento de resolução da imagem (píxel), que varia de 1 km x "
                            + "1 km até 5 km x 4 km – tecnicamente, o Inpe chama os registros de “focos de calor”."));

                    geraGrafRelatorio(documento, "Goiás", graficos[7], tbGoias);
                    documento.add(new Paragraph("\n\n       O cerrado é um dos principais biomas do país, ocupa cerca de 22% de todo o território, mas sofre "
                            + "com a ameaça constante de extinção, essa previsão pessimista é proveniente do atual quadro "
                            + "ambiental em que se encontra o cerrado, no qual, aproximadamente 80% da biodiversidade já "
                            + "sofreu alterações na fauna e flora, em Goiás a situação é mais agravante pois estimativas revelam "
                            + "que cerca de 90% de todo bioma já se encontra alterado. "
                            + "\n       Em Goiás, os parques de preservação representam apenas 1% de todo cerrado goiano, enquanto "
                            + "que em outros estados a média é de 2,5%, esses dados estão muito abaixo das metas "
                            + "internacionais que é de 10%, esse percentual deveria ser revertido em reservas ambientais em "
                            + "Goiás."));

                    geraGrafRelatorio(documento, "Maranhão", graficos[8], tbMaranhao);
                    documento.add(new Paragraph("\n\n       A redução de 40% nas emissões de gases efeitos estufa provenientes do desmatamento no "
                            + "Cerrado é uma das metas voluntárias assumidas pelo Brasil na Conferência das Nações Unidas "
                            + "sobre Mudanças do Clima, realizada em Copenhague, na Dinamarca. O compromisso foi "
                            + "transformado em lei aprovada pelo Congresso e sancionada pelo ex-presidente Lula. "
                            + "\n       Dentro do PPCerrado, estão em andamento pelo MMA estão a elaboração do "
                            + "Zoneamento Econômico Ecológico (ZEE) do Cerrado e o Cadastro Ambiental Rural. Além disso, "
                            + "existem propostas de ampliação do número de Unidades de Conservação para o Bioma em áreas "
                            + "prioritárias para a conservação da biodiversidade. "
                            + "\n       O Maranhão é o estado com o maior número de municípios na lista de prioridades. No "
                            + "período apurado, 20 unidades federadas desmataram área superior a 25 quilômetros quadrados. "
                            + "O limite é compatível com o que prevê a lei, que permite com que as propriedades rurais "
                            + "desmatem até 75% das áreas. Bahia e Tocantins vêm em seguida com oito e o Piauí, com seis, "
                            + "ocupa o terceiro lugar."));

                    geraGrafRelatorio(documento, "Mato Grosso", graficos[9], tbMatoGrosso);
                    documento.add(new Paragraph("\n\n       Mato Grosso perdeu quase mil quilômetros quadrados de Cerrado em 2018. Estudo do "
                            + "\n       ICV mostra que apenas uma pequena fração desse desmatamento foi feita com autorização do "
                            + "órgão ambiental, obedecendo a legislação vigente. A taxa de ilegalidade inaceitável e persistente, "
                            + "95% neste ano, é uma das maiores ameaças à conservação do bioma. "
                            + "\n       De agosto de 2017 a julho de 2018, o desmatamento mapeado no Cerrado brasileiro pelo "
                            + "Instituto Nacional de Pesquisas Espaciais (Inpe) foi de 6.657 km², uma área equivalente a quatro "
                            + "vezes a cidade de São Paulo. Mato Grosso foi o terceiro estado que mais desmatou o bioma, "
                            + "foram 998 km², respondendo por 15% de todo o Cerrado perdido no Brasil em um ano. "
                            + "\n       De acordo com a análise das características do desmatamento realizada pelo Instituto "
                            + "Centro de Vida, cerca de um terço de todo desmatamento no Cerrado mato-grossense ocorreu "
                            + "em imóveis rurais cadastrados e em áreas contínuas de mais de 50 hectares, ou seja, facilmente "
                            + "detectáveis via imagens de satélite. “É urgente que o Poder Público tome medidas sérias para "
                            + "conter a ilegalidade."));

                    geraGrafRelatorio(documento, "Mato Grosso do Sul", graficos[10], tbMatoGrossodoSul);
                    documento.add(new Paragraph("\n\n       O Cerrado, um dos biomas mais importantes do mundo, que ocupa a maior parcela do território "
                            + "de Mato Grosso do Sul, corre o risco de perder 1140 espécies de plantas até 2050, pelas "
                            + "atividades agropecuárias. É o que alerta um estudo publicado pela revista “Nature Ecology & "
                            + "Evolution”, divulgado hoje pelo jornal O Globo.n"
                            + "Bernardo Strassburg é o principal responsável pela pesquisa e diretor do Instituto Internacional "
                            + "para a Sustentabilidade. O autor afirma que ainda que o desmatamento fosse paralisado hoje, o "
                            + "bioma perderia 657 espécies de plantas em função dos 46% que já foram desmatados. "
                            + "\n       “Falamos de perda de biodiversidade, de segurança hídrica e climática. Um hectare "
                            + "desmatado de Cerrado tem mais impacto hoje do que um hectare desmatado na Amazônia. Não "
                            + "se trata de impedir a produção agrícola. Ao contrário, ela tem condições de aumentar sem "
                            + "precisar desmatar mais”, comentou."));

                    geraGrafRelatorio(documento, "Minas Gerais", graficos[11], tbMinasGerais);
                    documento.add(new Paragraph("\n\n       O cerrado, com paus-terra de flores amarelas e jacarandás de cascas escuras, dominava "
                            + "o alto do morro, compondo com a mata ciliar do Rio das Velhas um corredor contínuo de "
                            + "vegetação fechada, onde comunidades próximas convivem com lontras, tatus, seriemas e outros "
                            + "animais. Até 2008, esse fragmento de mata nativa de 108 hectares (ha) permaneceu intacto, "
                            + "resistindo ao avanço das fronteiras agrícolas e da especulação imobiliária na região de Lagoa "
                            + "Santa, na Grande BH. Mas, no ano seguinte, uma clareira de 3,86 ha surgiu sem licença para "
                            + "desmatamento. Dois anos depois, uma plantação de hortaliças foi cultivada na floresta, escondida "
                            + "da fiscalização. É a agonia do cerrado, que se estende também para o Norte de Minas, agravada "
                            + "pela seca e pelo desmatamento. "
                            + "\n       O uso de tratores e motosserras para derrubar árvores sem qualquer incômodo da "
                            + "fiscalização em Lagoa Santa permitiu a expansão da devastação, que engoliu mais 6,34 ha em "
                            + "2014 e 2,3 ha neste ano, somando, em sete anos, 12,5 ha (11,6% da cobertura florestal total)."));

                    geraGrafRelatorio(documento, "Paraná", graficos[14], tbParana);
                    documento.add(new Paragraph("\n\n       Sua cobertura vegetal é a segunda maior do Brasil, abrangendo uma área de 20% do "
                            + "território nacional. No Paraná apresenta suas últimas manchas ao sul, atingindo anteriormente "
                            + "0,3% do território do Estado, ocorrendo nas Bacias Hidrográficas do Cinzas(município de Arapoti), "
                            + "e Itararé(município de Jaguariaíva), estas nas região nordeste do Estado, e nas regiões ao norte, "
                            + "na Bacia do Ivaí(municípios de Campo Mourão, Rondon e Indianópolis), Bacia do Pirapó "
                            + "(município de Sabáudia), e Bacia do Tibagi (município de São Jerônimo a Serra). "
                            + "\n       Manteve-se preservado até a década de 60. Desde então, tem sido crescentemente "
                            + "ameaçado, principalmente pela prática de queimadas constantes e o desmatamento ilegal para "
                            + "ceder lugar ao plantio de grandes áreas de monoculturas e ao pasto que alimenta a pecuária."));

                    geraGrafRelatorio(documento, "Piauí", graficos[16], tbPiaui);
                    documento.add(new Paragraph("\n\n       O desmatamento do Cerrado no Brasil aumentou cerca de 9% em 2017 comparado a "
                            + "2016, o que significa dizer que metade desse bioma que sempre existiu já desapareceu. Parte da "
                            + "vegetação do Piauí é composta pelo Cerrado e isso significa dizer que o estado também está "
                            + "perdendo, aos poucos, como todo o resto do país, parcela significativa do seu bioma natural. "
                            + "\n       No total, 7.408 quilômetros quadrados da vegetação foram convertidos para pastagens "
                            + "e soja. As informações são de artigo publicado por um grupo de dez pesquisadores brasileiros na "
                            + "revista Nature Climate Change e divulgado em reportagem do Estadão dessa sexta-feira (13). O "
                            + "texto analisa o que os autores chamam de “ameaça das barganhas políticas para a mitigação "
                            + "climática do Brasil”. "
                            + "\n       Segundo a reportagem, a previsão apontada no estudo - considerado o levantamento dos dados "
                            + "feitos ao longo dos anos - é que o desmatamento só se prolifere. Uma das justificativas para o "
                            + "aumento da devastação, conforme a matéria, é tanto a inoperância das políticas públicas "
                            + "governamentais anti-devastação quanto de preservação ambiental."));

                    geraGrafRelatorio(documento, "São Paulo", graficos[23], tbSaoPaulo);
                    documento.add(new Paragraph("\n\n       Aqui dentro, tanto quanto no exterior, a Amazônia recebe preocupação total da "
                            + "sociedade. Enquanto isso, a vegetação do cerrado vai sendo devastada, como se irrelevante fosse "
                            + "tal bioma. Isso não pode continuar. Biodiversidade não escolhe floresta para morar. "
                            + "\n       Recentemente o governo paulista fez aprovar, com apoio unânime da Assembleia "
                            + "Legislativa, sua lei de proteção ao cerrado, cuja aplicação prática será regulamentada agora, em "
                            + "11 de setembro, Dia Nacional do Cerrado. Serve de exemplo na proteção ambiental do País. "
                            + "\n       Já passava da conta. A vegetação típica de cerrado ocupava originalmente 14% do "
                            + "território paulista, representando 3,4 milhões de hectares. Fora os especialistas, ninguém sabia "
                            + "disso. Hoje, mal cobre 211 mil hectares, restando em apenas 0,84% da área do Estado. Quase "
                            + "desapareceu. "
                            + "\n       O cerrado sempre foi considerado bioma de menor importância, seja para os agricultores, "
                            + "seja para os próprios ecologistas. A exuberância da Amazônia e, no Sudeste, a relevância da mata "
                            + "atlântica encobrem a riqueza da fauna e da flora típicas dessas savanas nacionais."));

                    geraGrafRelatorio(documento, "Tocantins", graficos[25], tbTocantins);
                    documento.add(new Paragraph("\n\n       Desmatamento do Cerrado reduz 9,8% no Tocantins entre 2017 e 2018. O ritmo de devastação "
                            + "do Cerrado, bioma que já perdeu quase metade da área original, diminuiu no último ano. A taxa "
                            + "de perda de vegetação caiu 11% entre agosto de 2017 e julho de 2018, na comparação com o "
                            + "período anterior, que por sua vez tinha apresentado uma alta cerca de 10%. Os dados foram "
                            + "divulgados ontem pelo governo federal durante a 24º Conferência do Clima da OU. No Tocantins, "
                            + "o desmatamento do bioma Cerrado reduziu 9,8%."));

                } else if (bioma.equals("Mata Atlântica")) {

                    geraGrafRelatorio(documento, bioma, graficos[26], tbGeral);
                    documento.add(new Paragraph("\n\n       Mata Atlântica é o nome popular dado à floresta tropical atlântica que se distribui em "
                            + "milhares de fragmentos da região litorânea aos planaltos e serras do interior, do Rio Grande do "
                            + "Norte ao Rio Grande do Sul. Originalmente, essa formação vegetal ocupava uma área de "
                            + "1.300.000 km², em áreas de 17 estados (PI, CE, RN, PB, PE, AL, SE, BA, ES, RJ, MG, GO, MS, SP, PR, "
                            + "SC, RS), ocorrendo de forma contínua entre RN e RS. Estreita na Região Nordeste, ela alargava-se "
                            + "para o Sul, até atingir sua largura máxima na bacia do Rio Paraná, penetrando, inclusive, no "
                            + "Paraguai e Argentina. Atualmente sua área fica em torno de 6 a 8% da original. "
                            + "\n       A Mata Atlântica, sem perder certa homogeneidade, apresenta "
                            + "um conjunto de formações florestais bastante diversificadas, que são: Floresta Ombrófila Densa, "
                            + "Floresta Ombrófila Mista, Floresta Ombrófila Aberta, Floresta Estacional Semidecidual e Floresta "
                            + "Estacional Decidual. Além disso, alguns ecossistemas estão associados a esse bioma, como "
                            + "o manguezal, restinga, campos de altitude, e brejos interioranos. Essa variedade é resultado das "
                            + "variações climáticas e de relevo."));

                    geraGrafRelatorio(documento, "Alagoas", graficos[1], tbAlagoas);
                    documento.add(new Paragraph("\n\n       Alagoas é o segundo estado do país que menos desmatou as áreas de Mata Atlântica entre "
                            + "2017 e 2018, de acordo com informações da Fundação SOS Mata Atlântica, divulgadas pelo "
                            + "Instituto do Meio Ambiente (IMA) nesta quinta-feira (23). "
                            + "A Mata Atlântica cobre 17 estados do país. O levantamento feito pela fundação mostra que no "
                            + "período entre 2017 e 2018, 113 km² de vegetação foram desmatados em todo o país."));

                    geraGrafRelatorio(documento, "Bahia", graficos[4], tbBahia);
                    documento.add(new Paragraph("\n\n       Os municípios de Santa Cruz Cabrália, Belmonte e Porto Seguro, no Litoral Sul da Bahia, e "
                            + "Wanderley, no Oeste, estão entre os cincos maiores desmatadores da Mata Atlântica na Região "
                            + "Nordeste. Juntos, eles desmataram no ano passado 7.211,86 hectares de florestas. Em todo o "
                            + "estado, em 2016, existia 2.014.528 hectares de florestas, a maior parte deles no litoral Sul. "
                            + "\n       O estudo foi apresentado pelo Instituto Nacional de Pesquisas Espaciais (INPE) e pela Fundação "
                            + "SOS Mata Atlântica, que traça um perfil dos municípios dos nove estados da Região Nordeste "
                            + "entre 2015 e 2016. O estudo revelou que a Bahia foi o Estado com maior número de municípios "
                            + "entre os que mais desmatam, com 30 cidades, seguido pelo Piauí, com sete. Em todo o Brasil as "
                            + "florestas de Mata Atlântica se fazem presentes em 17 estados. A Bahia é o quinto estado no "
                            + "país com maior área desse tipo de floresta. "
                            + "\n       Somente em um município da Bahia, Santa Cabrália, localizado no Extremo Sul "
                            + "do Estado, a área desmatada de Mata Atlântica é do tamanho do município de Madre de deus, "
                            + "na Região Metropolitana de Salvador."));

                    geraGrafRelatorio(documento, "Espírito Santo", graficos[6], tbEspiritoSanto);
                    documento.add(new Paragraph("\n\n       O Espírito Santo quase quadruplicou o número de hectares de mata atlântica desmatados nos"
                            + "últimos anos. De acordo com o levantamento da Fundação Mata Atlântica, o desflorestamento "
                            + "passou de 5 hectares em 2017 para 19 hectares em 2018, um aumento de 316%. "
                            + "\n       Com isso, o estado fica com 10,5% de seu território coberto pela mata atlântica. No cenário "
                            + "nacional o desmatamento da Mata Atlântica entre 2017 e 2018 caiu 9,3% em relação ao "
                            + "período anterior (2016-2017), que por sua vez já tinha sido o menor desmatamento registrado "
                            + "pela série histórica do Atlas da Mata Atlântica, iniciativa da Fundação SOS Mata Atlântica e do "
                            + "Instituto Nacional de Pesquisas Espaciais (INPE), que monitora o bioma desde 1985. "
                            + "\n       O relatório aponta que no último ano foram destruídos 11.399 hectares (ha), ou 113 Km², de "
                            + "áreas de Mata Atlântica acima de 3 hectares nos 17 estados do bioma. No ano anterior, o "
                            + "desmatamento tinha sido de 12.562 hectares (125 Km²)."));

                    geraGrafRelatorio(documento, "Goiás", graficos[7], tbGoias);
                    documento.add(new Paragraph("\n\n       O município de Caçu, localizado no extremo sudoeste goiano, foi o que mais desmatou a Mata "
                            + "Atlântica entre 2014 e 2015, com a eliminação de 21 hectares de florestas (aproximadamente a "
                            + "área de 21 campos de futebol). A cidade também foi a que mais conservou o seu bioma, com "
                            + "6,9% de vegetação natural, em relação à área original. Isso é o que mostra o Atlas dos "
                            + "Municípios da Mata Atlântica, lançado pela Fundação SOS Mata Atlântica e pelo Instituto "
                            + "Nacional de Pesquisas Espaciais (INPE). “Essa análise no estado de Goiás ressalta a importância "
                            + "no combate permanente ao desmatamento. A cidade que possui a maior área de bioma de "
                            + "Mata Atlântica conservada no estado é também a que corre o maior risco de ser "
                            + "desmatada, fato que ocorreu entre 2014 e 2015”, disse a diretora‐executiva da SOS Mata "
                            + "Atlântica, Marcia Hirota. Neste ano, em que a SOS Mata Atlântica comemora seu 30º "
                            + "aniversário, o estudo mapeou os 100 municípios que mais desmataram o bioma entre 1985 e "
                            + "2015. Goiás não conta com nenhum município entre os 100 que mais desmataram em todo o "
                            + "país nesse período."));

                    geraGrafRelatorio(documento, "Mato Grosso do Sul", graficos[10], tbMatoGrossodoSul);
                    documento.add(new Paragraph("\n\n       Mato Grosso do Sul perdeu 140 hectares de áreas de Mata Atlântica entre 2017 e 2018, "
                            + "segundo monitoramento da Fundação SOS Mata Atlântica e do Inpe (Instituto Nacional de "
                            + "Pesquisas Espaciais). O número mostra avanço de 21% no desmatamento do bioma. Entre 2016 "
                            + "e 2017, foram eliminados 116 hectares no Estado. "
                            + "\n       De acordo com monitoramento, Mato Grosso do Sul hoje tem 712.374 hectares de "
                            + "Mata Atlântica em seu território, que correspondem a 11,2% da área original. O Estado foi o "
                            + "oitavo, de 17, na lista dos que mais desmataram entre 2017 e 2018. Os “campeões” em "
                            + "eliminação da vegetação nativa foram Minas Gerais (3.379 ha), Paraná (2.049 ha) e Piauí (2.100 "
                            + "ha). "
                            + "\n       De acordo com o diretor de Políticas Públicas da Fundação SOS Mata Atlântica, Mario "
                            + "Mantovani, o desmatamento em Mato Grosso do Sul se concentra na região da Serra da "
                            + "Bodoquena, que contempla municípios como Bonito e Jardim."));

                    geraGrafRelatorio(documento, "Minas Gerais", graficos[11], tbMinasGerais);
                    documento.add(new Paragraph("\n\n       Minas Gerais lidera, pela sexta vez, o ranking de estados que mais desmataram a mata atlântica."
                            + "Foram destruídos 3.379 hectares da vegetação entre os anos de 2017 e 2018, segundo o Atlas "
                            + "da Mata Atlântica. "
                            + "O dado foi divulgado pela Fundação SOS Mata Atlântica no dia 23 de maio deste ano e lançado "
                            + "pelo diretor da fundação, Mário Mantovani, no Encontro Nacional do Diálogo Florestal, que é "
                            + "realizado nesta quinta-feira (13) em Belo Horizonte. "
                            + "\n       O estado ficou na liderança dos que mais desmatam a mata atlântica por cinco anos "
                            + "seguidos. Nas duas últimas edições do atlas, foi superado pela Bahia. "
                            + "A Associação Mineira de Defesa do Ambiente (Amda) denuncia que os dados desta edição do "
                            + "atlas mostram o esforço da Bahia em conter o desmatamento e conseguindo chegar ao quarto "
                            + "lugar neste ano."));

                    geraGrafRelatorio(documento, "Paraíba", graficos[13], tbParaiba);
                    documento.add(new Paragraph("\n\n       A Paraíba registrou uma redução de 47% nas ações de desflorestamento da Mata Atlântica no "
                            + "período 2017-2018, em comparação ao período de 2016-2017, de acordo com um relatório "
                            + "divulgado este ano pela Fundação SOS Mata Atlântica e pelo Instituto Nacional de Pesquisas "
                            + "Espaciais. Os dados indicam que o estado conserva apenas cerca de 11% da cobertura original "
                            + "desse bioma. "
                            + "\n       Em todo o país, incluindo outras 16 unidades da federação, o bioma abriga, segundo o "
                            + "Ministério do Meio Ambiente, cerca de 20 mil espécies vegetais, além de aproximadamente 850 "
                            + "espécies de aves, 370 de anfíbios, 270 de mamíferos e 350 de peixes. "
                            + "\n       Para Rubens Benini, gerente de estratégia de restauração florestal da organização The Nature "
                            + "Conservancy América Latina, a baixa cobertura no estado é preocupante. “Quando a gente "
                            + "chega a menos de 20% de um bioma em uma região, espécies já não conseguem se reproduzir. "
                            + "É preciso manter o máximo do bioma, conciliando com o desenvolvimento econômico”, "
                            + "explicou."));

                    geraGrafRelatorio(documento, "Paraná", graficos[14], tbParana);
                    documento.add(new Paragraph("\n\n       O Paraná é o terceiro estado que registrou maior desmatamento do bioma mata atlântica no "
                            + "último ano. O levantamento é da Fundação SOS Mata Atlântica e do Instituto Nacional de "
                            + "Pesquisas Espaciais (INPE) e se refere ao período entre entre outubro de 2017 e outubro de "
                            + "2018. "
                            + "\n       Em todo o Brasil, houve uma queda de 9,3% em relação ao período anterior (2016-2017). "
                            + "Apesar dos resultados positivos do relatório do último ano, cinco estados ainda mantêm índices "
                            + "inaceitáveis de desmatamento, segundo avaliação da SOS Mata Atlântica. São eles: Minas "
                            + "Gerais (3.379 ha), o Paraná (2.049 ha), Piauí (2.100 ha), a Bahia (1.985 ha) e Santa Catarina (905 "
                            + "ha). "
                            + "\n       Dos 17 estados da Mata Atlântica, nove estão no nível de desmatamento zero, com "
                            + "desflorestamentos abaixo de 100 hectares, o que equivale a 1 km²: Ceará (7 ha), Alagoas (8 ha), "
                            + "o Rio Grande do Norte (13 ha), Rio de Janeiro (18 ha), Espírito Santo (19 ha), a Paraíba (33 ha), "
                            + "Pernambuco (90 ha), São Paulo (96 ha) e Sergipe (98 ha)."));

                    geraGrafRelatorio(documento, "Pernambuco", graficos[15], tbPernambuco);
                    documento.add(new Paragraph("\n\n       Entre as capitais do Brasil, Recife é a terceira que mais preserva Mata Atlântica, proporcionalmente."
                            + "Os dados da Fundação SOS Mata Atlântica e o Instituto Nacional de Pesquisas Espaciais (INPE) foram "
                            + "divulgados nesta quarta-feira (11), como parte do \"Atlas dos Municípios da Mata Atlântica\". A capital "
                            + "pernambucana está 100% inserida no bioma e tem 20% dele preservado, um percentual que "
                            + "corresponde a 4,4 mil hectares. "
                            + "\n       Atualmente, a Mata Atlântica é a floresta mais ameaçada do Brasil, com apenas 12,5% da área "
                            + "original preservada. Em primeiro e segundo lugar do ranking de preservação ficaram as capitais do "
                            + "Rio Grande do sul e de Santa Catarina, com 32% e 25% de Mata Atlântica preservada, "
                            + "respectivamente. "
                            + "\n       Em Pernambuco, o município de Goiana, Mata Norte, lidera a lista dos municípios que mais "
                            + "desmataram entre os anos de 2000 e 2014. Ela apresentou um desflorestamento da Mata Atlântica "
                            + "de 86 hectares nesse período. Já o município de Abreu e Lima se destacou quanto à preservação. A "
                            + "região conseguiu manter 62,1% da vegetação natural."));

                    geraGrafRelatorio(documento, "Rio de Janeiro", graficos[17], tbRiodeJaneiro);
                    documento.add(new Paragraph("\n\n       O município de Resende, no Sul do Rio de Janeiro, lidera o ranking de desflorestamento de Mata "
                            + "Atlântica no estado entre 2000 e 2014, segundo pesquisas divulgada nesta quarta-feira (11) pela "
                            + "Fundação SOS Mata Atlântica. A capital aparece na quarta colocação (veja tabela abaixo). "
                            + "\n       Angra dos Reis, na Costa Verde, é a que mantém maior área proporcional de Mata Atlântica "
                            + "preservada, com 80,1% de vegetação natural, comparado com a área original. A capital fluminense, "
                            + "por sua vez, conta com aproximadamente 18% de vegetação natural do bioma. "
                            + "\n       A vegetação natural inclui, além das florestas nativas, os refúgios, várzeas, campos de altitude, "
                            + "mangues, restingas e dunas. "
                            + "\n       A Prefeitura de Resende, por meio de nota, questiona os dados apontados pela ONG e diz que a "
                            + "\"grande maioria das queimadas registradas no Parque Nacional do Itatiaia acontece em áreas de "
                            + "pasto, sob o domínio do Governo Federal"));

                    geraGrafRelatorio(documento, "Rio Grande do Norte", graficos[18], tbRioGrandedoNorte);
                    documento.add(new Paragraph("\n\n       O maior parque urbano do país sobre dunas, o Parque das Dunas, é apenas uma das principais "
                            + "reservas de Mata Atlântica no Rio Grande do Norte. Com cerca de 1.170 hectares, o local abriga "
                            + "mais de 250 espécies de plantas e animais. Além do parque, o RN ainda conserva outros "
                            + "remanescentes do bioma, como a Área de Proteção Ambiental Bonfim-Guaraíras que possui 42 "
                            + "mil hectares de Mata Atlântica em área dos municípios de Goianinha, Canguaretama, Espírito "
                            + "Santo, Pedro Velho e Várzea, e a APA Piquiri-Una que soma 40 mil hectares em área de cinco "
                            + "municípios da região agreste do Estado - Tibau do Sul, Goianinha, Arês, Senador Georgino Avelino, "
                            + "Nísia Floresta e São José de Mipibu. "
                            + "\n       O trabalho de preservação e conservação ambiental desses e outros trechos da Mata Atlântica "
                            + "em 38 municípios do RN rendeu bons frutos."));

                    geraGrafRelatorio(documento, "Rio Grande do Sul", graficos[19], tbRioGrandedoSul);
                    documento.add(new Paragraph("\n\n       Nos últimos 30 anos, o Rio Grande do Sul teve 97.994 hectares de Mata Atlântica desmatados, área "
                            + "que equivale a aproximadamente duas vezes o tamanho da cidade de Porto Alegre. Dos 13.857.127 "
                            + "hectares de vegetação original do Estado, restam apenas 7,9%. O dados são da nova edição do Atlas "
                            + "dos Remanescentes Florestais da Mata Atlântica, divulgado nesta quinta-feira pela Fundação SOS "
                            + "Mata Atlântica e pelo Instituto Nacional de Pesquisas Espaciais (Inpe). O documento, referente ao "
                            + "período de 2014 a 2015, traz uma análise consolidada da devastação em 30 anos de monitoramento "
                            + "nos 17 Estados brasileiros que apresentam resquícios do bioma. "
                            + "\n       O trabalho observou que, no ano passado, a Mata Atlântica brasileira perdeu 18.433 hectares, taxa "
                            + "1% maior que a do período anterior, que foi de 18.267 ha. São valores menores do que os registrados "
                            + "entre 2011 e 2013 – quando, por dois anos consecutivos, a taxa voltou a crescer –, mas ainda "
                            + "superiores às perdas ocorridas entre 2008 e 2011, as menores da história do monitoramento do "
                            + "bioma."));

                    geraGrafRelatorio(documento, "Santa Catarina", graficos[22], tbSantaCatarina);
                    documento.add(new Paragraph("\n\n       Santa Catarina é um dos cinco estados brasileiros que mantêm índices considerados "
                            + "inaceitáveis de desmatamento, de acordo com a Fundação SOS Mata Atlântica e o Instituto "
                            + "Nacional de Pesquisas Espaciais (INPE). A última edição do Atlas da Mata Atlântica, "
                            + "levantamento que monitora o bioma desde 1985, mostra que 905 hectares de mata localizados "
                            + "em território catarinense desapareceram entre o biênio 2017/2018. "
                            + "\n       Os dados, divulgados no dia 23 deste mês, indicam um aumento de 52% no "
                            + "desflorestamento, comparado ao biênio anterior — 2016/2017, quando ocorreu redução de "
                            + "595 hectares. "
                            + "\n       A perda de cobertura florestal deixa o Estado em alerta, conforme a diretora-executiva "
                            + "da Fundação S.O.S Mata Atlântica, Márcia Hirota. "
                            + "O cenário de SC é ainda mais preocupante quando se compara os números do "
                            + "desflorestamento no país. Dos 17 estados em que o bioma está presente, nove estão no nível "
                            + "do desmatamento zero, com perdas abaixo de 100 hectares, ou 1 Km²."));

                    geraGrafRelatorio(documento, "São Paulo", graficos[23], tbSaoPaulo);
                    documento.add(new Paragraph("\n\n       A cidade de São Paulo somou pelo menos 90 novas áreas de Mata Atlântica desmatadas nos "
                            + "últimos 5 anos, de acordo com um dossiê divulgado pela equipe do vereador Gilberto Natalini "
                            + "(PV) neste mês. O relatório denuncia a derrubada de pelo menos 500 mil árvores nos extremos "
                            + "leste e sul do município. Os maiores responsáveis pelo desmatamento são organizações que "
                            + "fazem loteamentos irregulares de áreas, de acordo com o estudo. "
                            + "\n       As áreas devastadas compõem Áreas de Proteção de Ambiental (APA) e Parques Naturais, que "
                            + "abrigam nascentes, a maior parte delas, responsáveis por abastecer a Represa Guarapiranga, na "
                            + "Zona Sul de São Paulo, cujas águas são consumidas por mais de 5 milhões de pessoas. "
                            + "\n       Segundo a Fundação SOS Mata Atlântica, o bioma ocupa 15% do território brasileiro, se "
                            + "concentra na costa, passa por 17 estados do país, e sua extensão hoje representa 12,4% da área "
                            + "original. A cidade de São Paulo abriga 17% dos remanescentes florestais"));

                    geraGrafRelatorio(documento, "Sergipe", graficos[24], tbSergipe);
                    documento.add(new Paragraph("\n\n       Sergipe registrou desmatamento ‘zero’ da Mata Atlântica entre 2017 e 2018 em relação ao "
                            + "período anterior (2016-2017). A informação foi divulgada nesta quinta-feira (23) pela Fundação "
                            + "SOS Mata Atlântica em parceria com o Instituto Nacional de Pesquisas Espaciais (Inpe). "
                            + "\n       Segundo o levantamento, Sergipe possui 98 hectares do bioma no estado. E apresentou uma "
                            + "variação de -71% em relação a situação anterior."));

                } else if (bioma.equals("Pampa")) {

                    geraGrafRelatorio(documento, bioma, graficos[26], tbGeral);
                    documento.add(new Paragraph("\n\n       O Pampa, também denominado Pampas, Campanha Gaúcha, Campos Sulinos ou Campos do Sul "
                            + "é o único bioma brasileiro presente somente numa unidade federativa. "
                            + "Ou seja, ocupa mais da metade do território do Rio Grande do Sul e parte dos "
                            + "países: Uruguai e Argentina. "
                            + "\n       O clima do Pampa é subtropical com as quatro estações do ano bem definidas e sua vegetação "
                            + "é marcada pela presença de gramíneas, plantas rasteiras, arbustos e árvores de pequeno porte. "
                            + "\n       As atividades econômicas desenvolvidas na região do Pampa, ou seja, a agricultura e pecuária, "
                            + "marcadas pela expansão das pastagens e dos campos de cultivo, são os principais responsáveis "
                            + "pelo desmatamento e degradação desse bioma. "
                            + "\n       O resultado é o desaparecimento de espécies nativas, aumento do processo de arenização do "
                            + "solo, bem como a invasão de espécies que levam ao desiquilíbrio do ecossistema."));

                    geraGrafRelatorio(documento, "Rio Grande do Sul", graficos[19], tbRioGrandedoSul);
                    documento.add(new Paragraph("\n\n       O Ministério do Meio Ambiente (MMA) anunciou, dia 22 de julho, que o bioma Pampa, que "
                            + "ocupa a maior parte do território do Rio Grande do Sul, já perdeu 54% de sua vegetação nativa "
                            + "ao longo de sua ocupação histórica. Entre 2002 e 2008, 2.183 quilômetros quadrados de "
                            + "cobertura nativa foram derrubados. No total, o bioma Pampa já perdeu mais de 95 mil "
                            + "quilômetros quadrados da vegetação original. Uma das causas apontadas pelo MMA como "
                            + "responsáveis pela destruição da vegetação nativa são os reflorestamentos de espécies exóticas "
                            + "plantadas para a fabricação de papel. Para reverter esse quadro, o Ministério propôs, entre "
                            + "outras soluções, a criação de novas unidades de conservação no bioma, a adoção de boas "
                            + "práticas na agricultura e pecuária e a observação das orientações do zoneamento econômicoecológico recentemente formulado pelo Conselho de Meio Ambiente do Rio Grande do Sul."));

                } else if (bioma.equals("Pantanal")) {

                    geraGrafRelatorio(documento, bioma, graficos[26], tbGeral);
                    documento.add(new Paragraph("\n\n       O bioma Pantanal é considerado uma das maiores extensões úmidas contínuas do planeta. Este "
                            + "bioma continental é considerado o de menor extensão territorial no Brasil, entretanto este "
                            + "dado em nada desmerece a exuberante riqueza que o referente bioma abriga. A sua área "
                            + "aproximada é 150.355 km² (IBGE,2004), ocupando assim 1,76% da área total do território "
                            + "brasileiro. Em seu espaço territorial o bioma, que é uma planície aluvial, é influenciado por rios "
                            + "que drenam a bacia do Alto Paraguai. "
                            + "\n       O Pantanal sofre influência direta de três importantes biomas brasileiros: Amazônia, Cerrado e "
                            + "Mata Atlântica. Além disso sofre influência do bioma Chaco (nome dado ao Pantanal localizado "
                            + "no norte do Paraguai e leste da Bolívia). Estudos indicam que o bioma "
                            + "abriga os seguintes números de espécies catalogadas: 263 espécies de peixes, 41 espécies de "
                            + "anfíbios, 113 espécies de répteis, 463 espécies de aves e 132 espécies de mamíferos sendo 2 "
                            + "endêmicas."));

                    geraGrafRelatorio(documento, "Mato Grosso", graficos[9], tbMatoGrosso);
                    documento.add(new Paragraph("\n\n       O território que compreende o Pantanal Mato-Grossense é considerado a maior planície de "
                            + "inundação do planeta, englobando o sudoeste do Mato Grosso, o oeste do Mato Grosso do Sul, "
                            + "e parte do Paraguai e Bolívia. Considerado um dos mais extraordinários patrimônios naturais do "
                            + "Brasil, possui uma biodiversidade faunística apenas superada pela existente na Amazônia, "
                            + "porém apresentando maior número de indivíduos por espécies. "
                            + "Contudo, nos últimos 20 anos, essa riqueza biológica natural tem sido ameaçada pela crescente "
                            + "expansão agrícola e urbana. "
                            + "\n       Devido aos processos erosivos provocados pela agricultura e pela ocupação urbana "
                            + "desordenada, principalmente em área que legalmente deveria ser preservada, temos hoje um "
                            + "quadro degradante de poluição, atingindo as nascentes e comprometendo a existência de "
                            + "animais e vegetais. Bem como a contaminação do solo pelo uso de agrotóxicos utilizados na "
                            + "agricultura."));

                    geraGrafRelatorio(documento, "Mato Grosso do Sul", graficos[10], tbMatoGrossodoSul);
                    documento.add(new Paragraph("\n\n       Mato Grosso do Sul perdeu 50 hectares de áreas de Pantanal entre 2017 e 2018, "
                            + "segundo monitoramento da Fundação SOS Pantanal e do Inpe (Instituto Nacional de "
                            + "Pesquisas Espaciais). O número mostra avanço de 21% no desmatamento do bioma. Entre 2016 "
                            + "e 2017, foram eliminados 116 hectares no Estado. "
                            + "\n       De acordo com monitoramento, Mato Grosso do Sul hoje tem 712.374 hectares de "
                            + "Pantanal em seu território, que correspondem a 11,2% da área original. O Estado foi o "
                            + "oitavo, de 17, na lista dos que mais desmataram entre 2017 e 2018. Os “campeões” em "
                            + "eliminação da vegetação nativa foram Minas Gerais (3.379 ha), Paraná (2.049 ha) e Piauí (2.100 "
                            + "ha)."));

                }

                Desktop.getDesktop().open(new File("relatorios//" + nomeArquivo + ".pdf"));

            } catch (DocumentException | IOException de) {
                System.err.println(de.getMessage());
            }
            documento.close();
        } else if (nomeArquivo.equals("")) {
            JOptionPane.showMessageDialog(null, "O nome do arquivo está em branco", "Nome do Arquivo em Branco", JOptionPane.INFORMATION_MESSAGE, icone);

        }


    }//GEN-LAST:event_geraRelatorio


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeraRelatorio;
    private javax.swing.JButton btnUpConfirma;
    private javax.swing.JButton btnUpConfirma1;
    private javax.swing.JComboBox<String> cboAte;
    private javax.swing.JComboBox<String> cboConBioma;
    private javax.swing.JComboBox<String> cboDe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbBioma;
    private javax.swing.JLabel lbBioma1;
    private javax.swing.JLabel lbBioma3;
    private javax.swing.JLabel lbInfRelatorio;
    private javax.swing.JLabel lbIntroBioma;
    private javax.swing.JLabel lbIntroducao;
    private javax.swing.JPanel pAcre;
    private javax.swing.JPanel pAlagoas;
    private javax.swing.JPanel pAmapa;
    private javax.swing.JPanel pAmazonas;
    private javax.swing.JPanel pAreaGraficos;
    private javax.swing.JPanel pBahia;
    private javax.swing.JPanel pCeara;
    private javax.swing.JPanel pEspiritoSanto;
    private javax.swing.JPanel pGeral;
    private javax.swing.JPanel pGoias;
    private javax.swing.JPanel pGrafAcre;
    private javax.swing.JPanel pGrafAlagoas;
    private javax.swing.JPanel pGrafAmapa;
    private javax.swing.JPanel pGrafAmazonas;
    private javax.swing.JPanel pGrafBahia;
    private javax.swing.JPanel pGrafCeara;
    private javax.swing.JPanel pGrafEspiritoSanto;
    private javax.swing.JPanel pGrafGeral;
    private javax.swing.JPanel pGrafGoias;
    private javax.swing.JPanel pGrafMaranhao;
    private javax.swing.JPanel pGrafMatoGrosso;
    private javax.swing.JPanel pGrafMatoGrossodoSul;
    private javax.swing.JPanel pGrafMinasGerais;
    private javax.swing.JPanel pGrafPara;
    private javax.swing.JPanel pGrafParaiba;
    private javax.swing.JPanel pGrafParana;
    private javax.swing.JPanel pGrafPernambuco;
    private javax.swing.JPanel pGrafPiaui;
    private javax.swing.JPanel pGrafRioGrandedoNorte;
    private javax.swing.JPanel pGrafRioGrandedoSul;
    private javax.swing.JPanel pGrafRiodeJaneiro;
    private javax.swing.JPanel pGrafRondonia;
    private javax.swing.JPanel pGrafRoraima;
    private javax.swing.JPanel pGrafSantaCatarina;
    private javax.swing.JPanel pGrafSaoPaulo;
    private javax.swing.JPanel pGrafSergipe;
    private javax.swing.JPanel pGrafTocantins;
    private javax.swing.JPanel pInfConsulta;
    private javax.swing.JPanel pMaranhao;
    private javax.swing.JPanel pMatoGrosso;
    private javax.swing.JPanel pMatoGrossodoSul;
    private javax.swing.JPanel pMinasGerais;
    private javax.swing.JPanel pPara;
    private javax.swing.JPanel pParaiba;
    private javax.swing.JPanel pParana;
    private javax.swing.JPanel pPernambuco;
    private javax.swing.JPanel pPiaui;
    private javax.swing.JPanel pRioGrandedoNorte;
    private javax.swing.JPanel pRioGrandedoSul;
    private javax.swing.JPanel pRiodeJaneiro;
    private javax.swing.JPanel pRondonia;
    private javax.swing.JPanel pRoraima;
    private javax.swing.JPanel pSantaCatarina;
    private javax.swing.JPanel pSaoPaulo;
    private javax.swing.JPanel pSergipe;
    private javax.swing.JPanel pTocantins;
    private javax.swing.JScrollPane scrollTbGeral;
    private javax.swing.JTabbedPane tabEstados;
    private javax.swing.JTable tbAcre;
    private javax.swing.JTable tbAlagoas;
    private javax.swing.JTable tbAmapa;
    private javax.swing.JTable tbAmazonas;
    private javax.swing.JTable tbBahia;
    private javax.swing.JTable tbCeara;
    private javax.swing.JTable tbEspiritoSanto;
    private javax.swing.JTable tbGeral;
    private javax.swing.JTable tbGoias;
    private javax.swing.JTable tbMaranhao;
    private javax.swing.JTable tbMatoGrosso;
    private javax.swing.JTable tbMatoGrossodoSul;
    private javax.swing.JTable tbMinasGerais;
    private javax.swing.JTable tbPara;
    private javax.swing.JTable tbParaiba;
    private javax.swing.JTable tbParana;
    private javax.swing.JTable tbPernambuco;
    private javax.swing.JTable tbPiaui;
    private javax.swing.JTable tbRioGrandedoNorte;
    private javax.swing.JTable tbRioGrandedoSul;
    private javax.swing.JTable tbRiodeJaneiro;
    private javax.swing.JTable tbRondonia;
    private javax.swing.JTable tbRoraima;
    private javax.swing.JTable tbSantaCatarina;
    private javax.swing.JTable tbSaoPaulo;
    private javax.swing.JTable tbSergipe;
    private javax.swing.JTable tbTocantins;
    // End of variables declaration//GEN-END:variables
}
