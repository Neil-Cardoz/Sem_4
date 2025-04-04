public class ExceptionClass2 {
    public static void validateEmailID(String emailID) throws InvalidEmailIDException {
        if (emailID.chars().filter(ch -> ch == '@').count() > 1) {
            throw new InvalidEmailIDException("Invalid email ID: Multiple '@' symbols found.");


        }
        String[] emailParts = emailID.split("@");
        for (String emailPart : emailParts) {
            System.out.println(emailPart);
        }
        if (emailParts[0].length() < 8) {
            throw new InvalidEmailIDException(" User Name is too short ");
        }
        if (!emailParts[1].contains(".")) {
            throw new InvalidEmailIDException(" User name does not contain \".\" "); // Excaping A Character
        }
        String[] domainParts = emailParts[1].split("\\.");
        System.out.println("Length of the domain Parts" + domainParts.length);

        for (String domainPart : domainParts) {
            System.out.println(domainPart);
            if (!domainParts[1].contains("com")) (!domainPart[1].contains("org")) && (!domainPart[1].contains)
        }
    }

    class InvalidEmailIDException extends Exception {
        public InvalidEmailIDException(String msg) {
            super(msg);
        }
    }
}
