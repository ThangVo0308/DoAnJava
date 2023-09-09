package GUI;
import java.awt.FileDialog;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import BUS.BUS_ChitietHD;
import BUS.BUS_Dienthoai;
import BUS.BUS_Hoadon;
import BUS.BUS_Khachhang;
import BUS.BUS_Nhanvien;
import DTO.DTO_ChitietHD;
import DTO.DTO_Hoadon;

public class ExportPDF {
	Document document;
    FileOutputStream file;
    com.itextpdf.text.Font fontData;
    com.itextpdf.text.Font fontTitle;
    com.itextpdf.text.Font fontHeader;

    FileDialog fd = new FileDialog(new JFrame(), "Xuat excel", FileDialog.SAVE);

    public ExportPDF() {
        try {
            fontData = new com.itextpdf.text.Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, com.itextpdf.text.Font.NORMAL);
            fontTitle = new com.itextpdf.text.Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, com.itextpdf.text.Font.NORMAL);
            fontHeader = new com.itextpdf.text.Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13, com.itextpdf.text.Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
//            Logger.getLogger(ExportPDF.class.getName()).log(Level.SEVERE, null, ex);
        	JOptionPane.showMessageDialog(null, "test");
        }
    }

    public void ChooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream("C:\\Users\\ASUS_2\\Desktop\\testjava.pdf"));
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void SetTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
//        JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
            ex.printStackTrace();
        }
    }

    public void WriteObject(String[] data) {
        Paragraph pdfData = new Paragraph();
        for (int i = 0; i < data.length; i++) {
            pdfData.add(data[i] + "  ");
        }
        try {
        	document.add(pdfData);
        } catch (DocumentException ex) {
//            Logger.getLogger(ExportPDF.class.getName()).log(Level.SEVERE, null, ex);
        	JOptionPane.showMessageDialog(null, "test");
        }
    }

    public void WriteTable(JTable _table) {
        PdfPTable pdfTable = new PdfPTable(_table.getColumnCount());
        for (int i = 0; i < _table.getRowCount(); i++) {
            for (int j = 0; j < _table.getColumnCount(); j++) {
                String data = String.valueOf(_table.getValueAt(i, j));
                PdfPCell cell = new PdfPCell(new Phrase(data, fontData));
                pdfTable.addCell(cell);
            }
        }
        try {
        	document.add(pdfTable);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    private String GetFile() {
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setDialogTitle("Chọn vị trí lưu tệp PDF");
    	int userSelection = fileChooser.showSaveDialog(null);
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    	    String url = fileChooser.getSelectedFile().getAbsolutePath() +".pdf";
    	    return url;
    	} else {
    	    return null;
    	}

    }

    public void writeHoaDon(ArrayList<DTO_Hoadon> dsHD, DTO_Hoadon hd) {
        String url = "";
        try {
            fd.setTitle("In hoa don");
            url = GetFile();
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance((com.itextpdf.text.Document) document, file);
            document.open();

            setTitle("Thong tin hoa don");
            Paragraph title = new Paragraph("Thông tin hóa đơn", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            //Hien thong tin cua hoa don hien tai

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph paraMaHoaDon = new Paragraph(new Phrase("Mã hóa đơn: " + String.valueOf(hd.getMa_HD()), fontData));

            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add(String.valueOf("Mã khách hàng: " + (hd.getMa_KH())));
            para1.add(glue);
            para1.add("Ngày lập: " + String.valueOf(hd.getNgayLap_HD()));

            Paragraph para2 = new Paragraph();
            para2.setFont(fontData);
            para2.add(String.valueOf("Nhân viên: " + hd.getMa_NV()));

            document.add(paraMaHoaDon);
            document.add(para1);
            document.add(para2);

            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

          //Tạo table cho các chi tiết của hóa đơn
            PdfPTable pdfTable = new PdfPTable(4);

            //Thiết lập header cho bảng chi tiết
            pdfTable.addCell(new PdfPCell(new Phrase("Mã sản phẩm", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            //Thêm dòng trống để tạo khoảng cách
            pdfTable.completeRow();

            int tongTienAll = 0;
            BUS_ChitietHD buscthd = new BUS_ChitietHD();
            for (DTO_ChitietHD cthd : buscthd.getListCTHD()) {
                if (cthd.getMaHD().equals(hd.getMa_HD()) && cthd.isCheck_exist() == true) {
                    String maSP = cthd.getMaDT();
                    int giaTien = cthd.getGia();
                    int soLuong = cthd.getSL();
                    int tongTien = giaTien * soLuong;

                    pdfTable.addCell(new PdfPCell(new Phrase(maSP, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(getGiaTienFormatted(giaTien)), fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(soLuong), fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(getGiaTienFormatted(tongTien)), fontData)));
                    
                    tongTienAll += tongTien;
                }
            }
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);


            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng cần phải thanh toán: " + getGiaTienFormatted(tongTienAll), fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();

            JOptionPane.showMessageDialog(null, "Ghi file thanh cong: " + url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Loi khi ghi file " + url);
        }
    }

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}
	
}
