
package Helper;

import com.google.zxing.common.BitMatrix;

public class QRcodeTest {
    public static void main(String[] args) {
        Package pkg = BitMatrix.class.getPackage();
        System.out.println("ZXing Version:");
        System.out.println("Implementation Title: " + pkg.getImplementationTitle());
        System.out.println("Implementation Vendor: " + pkg.getImplementationVendor());
        System.out.println("Implementation Version: " + pkg.getImplementationVersion());
    }
}
