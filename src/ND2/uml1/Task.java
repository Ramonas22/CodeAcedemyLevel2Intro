package ND2.uml1;

class Task {

    String task(Integer month) {
        if (month > 0) {
            if (month < 13) {
                if (month % 2 == 0) {
                    switch (month) {
                        case 2 -> {
                            return "February";
                        }
                        case 4 -> {
                            return "April";
                        }
                        case 6 -> {
                            return "June";
                        }
                        case 8 -> {
                            return "August";
                        }
                        case 10 -> {
                            return "October";
                        }
                        case 12 -> {
                            return "December";
                        }
                    }
                } else {
                    switch (month) {
                        case 1 -> {
                            return "January";
                        }
                        case 3 -> {
                            return "March";
                        }
                        case 5 -> {
                            return "May";
                        }
                        case 7 -> {
                            return "July";
                        }
                        case 9 -> {
                            return "September";
                        }
                        case 11 -> {
                            return "November";
                        }
                    }
                }
            }
        }
        return "provided integer does not fit to months bound";
    }
}

