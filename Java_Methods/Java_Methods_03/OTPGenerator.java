import java.util.HashSet;

public class OTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; // 6-digit OTP
    }

    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) return false; // duplicate found
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

        System.out.println("Are all OTPs unique? " + areOTPsUnique(otps));
    }
}
