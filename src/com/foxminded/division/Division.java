package com.foxminded.division;

public class Division {

    public String divide(int dividend, int divider) {
        if (divider == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }

        dividend = Math.abs(dividend);
        divider = Math.abs(divider);
        StringBuilder resultBody = makeDivision(dividend, divider);
        insertHeader(dividend, divider, resultBody);
        return resultBody.toString();
    }

    private StringBuilder makeDivision(int dividend, int divider) {
        StringBuilder localResultBody = new StringBuilder();
        if (dividend < divider) {
            insertFractionalPart(dividend, divider, localResultBody);
        } else {
            insertWholePart(dividend, divider, localResultBody);
            insertFractionalPart(dividend, divider, localResultBody);
        }
        return localResultBody;
    }

    private void insertHeader(int dividend, int divider, StringBuilder resultBody) {
        String dividendBody = String.valueOf(dividend);
        String quotient = String.valueOf(dividend / divider);
        int dividendLength = String.valueOf(dividend).length();
        if (dividend % divider != 0) {
            quotient = calculateQuotient(dividend, divider, quotient);
        }

        int[] newLineIndexes = new int[3];
        for (int i = 0, j = 0; i < resultBody.length(); i++) {
            if (resultBody.charAt(i) == '\n') {
                newLineIndexes[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        if (dividend < divider) {
            if (String.valueOf(divider).length() == dividendLength) {
                dividendBody += " ";
            } else {
                int tab = String.valueOf(divider).length() - dividendLength;
                dividendBody += repeatString(tab, " ");
            }
        }
        int tab = dividendLength + 1 - newLineIndexes[0];
        resultBody.insert(newLineIndexes[2], repeatString(tab, " ") + "│" + quotient);
        resultBody.insert(newLineIndexes[1], repeatString(tab, " ") + "│" + repeatString(quotient.length(), "-"));
        resultBody.insert(newLineIndexes[0], "│" + divider);
        resultBody.replace(1, newLineIndexes[0], dividendBody);
    }

    private String repeatString(int length, String string) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            newString.append(string);
        }
        return newString.toString();
    }

    private void insertWholePart(int dividend, int divider, StringBuilder localResultBody) {
        String[] numbers = String.valueOf(dividend).split("");
        String residue = "";

        for (int i = 0; i < numbers.length; i++) {
            int localDividend = Integer.valueOf(residue + numbers[i]);

            if (localDividend < divider) {
                residue = String.valueOf(localDividend);

            } else {
                residue = String.valueOf(localDividend % divider);
                String partialQuotient = String.valueOf((localDividend / divider) * divider);
                final int shiftLength = 2;
                int tab = i + shiftLength;
                localResultBody.append(String.format("%" + tab + "s", "_" + String.valueOf(localDividend))).append("\n")
                        .append(String.format("%" + tab + "s", partialQuotient)).append("\n")
                        .append(String.format("%" + tab + "s", repeatString(partialQuotient.length(), "-"))).append("\n");
            }
        }
    }

    private void insertFractionalPart(int dividend, int divider, StringBuilder localResultBody) {
        String residue = String.valueOf(dividend % divider);
        int endWholePart = String.valueOf(dividend).length() - 1;
        final int shiftLength = 2;
        if (Integer.valueOf(residue) == 0) {
            localResultBody.append(String.format("%" + (endWholePart + shiftLength) + "s", residue)).append("\n");
        } else {
            int maxNumberDecimalPlaces = searchFractionalPartLength(dividend, divider);
            for (int i = 0, j = 0; i < maxNumberDecimalPlaces; i++) {
                int localFractional = Integer.valueOf(residue);
                int tab = endWholePart + j + shiftLength;
                if (localFractional < divider) {
                    j++;
                    i--;
                    residue = String.valueOf(localFractional) + "0";
                    if (localFractional == 0) {
                        localResultBody.append(String.format("%" + (tab + 1) + "s", residue)).append("\n");
                        break;
                    }
                } else {
                    residue = String.valueOf(localFractional % divider);

                    String partialQuotient = String.valueOf((localFractional / divider) * divider);
                    localResultBody.append(String.format("%" + tab + "s", "_" + String.valueOf(localFractional))).append("\n")
                            .append(String.format("%" + tab + "s", partialQuotient)).append("\n")
                            .append(String.format("%" + tab + "s", repeatString(partialQuotient.length(), "-"))).append("\n");
                }
                if (i == maxNumberDecimalPlaces - 1) {
                    localResultBody.append(String.format("%" + tab + "s", residue)).append("\n");
                }
            }
        }
    }

    private String calculateQuotient(int dividend, int divider, String quotient) {
        int checkPeriodExistence = 0;
        StringBuilder fractionalPart = new StringBuilder();
        int[] checkResidue = new int[searchFractionalPartLength(dividend, divider) + 1];
        int residue = dividend % divider;
        for (int i = 0; i < checkResidue.length; i++) {
            checkResidue[i] = residue;
            fractionalPart.append(String.valueOf((residue * 10) / divider));
            residue = (residue * 10) % divider;
            if (residue == 0) {
                break;
            }
            if (fractionalPart.length() > 10) {
                checkPeriodExistence++;
                break;
            }
            for (int j = 0; j < fractionalPart.length(); j++) {
                if (checkResidue[j] == residue) {
                    fractionalPart.insert(i + 1, ")").insert(j, "(");
                    i = checkResidue.length;
                    break;
                }
            }
        }
        if (checkPeriodExistence > 0) {
            double roundQuotient = Double.parseDouble(quotient + "." + fractionalPart);
            quotient = String.format("%.10f", roundQuotient).replace(',', '.');
        } else {
            quotient = quotient + "." + fractionalPart;
        }
        return quotient;
    }
    
    private int searchFractionalPartLength(int dividend, int divider) {
        int fractionalPartLength = 0;
        int[] maxSymbolsDecimalPoint = new int[10];
        int residue = dividend % divider;
        for (int i = 0; i < maxSymbolsDecimalPoint.length; i++) {
            maxSymbolsDecimalPoint[i] = residue;
            fractionalPartLength++;
            residue = (residue * 10) % divider;
            if (residue == 0) {
                break;
            }

            for (int j = 0; j < fractionalPartLength; j++) {
                if (maxSymbolsDecimalPoint[j] == residue) {
                    i = maxSymbolsDecimalPoint.length;
                    break;
                }
            }
        }
        return fractionalPartLength;
    }
}
