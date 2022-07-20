package ua.redTeam.peopleForPeople.utils.timeTextUtils.elapsedTime;

public class UATimeInflexionCreatorImpl implements LocaleInflexionCreator {

    @Override
    public String seconds(int seconds){
        switch (seconds){

            case 1: case 21: case 31: case 41: case 51:
                return "секунда";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
            case 32: case 33: case 34:
            case 42: case 43: case 44:
            case 52: case 53: case 54:
                return "секунди";

            default: return "секунд";
        }
    }

    @Override
    public String minutes(int minutes){
        switch (minutes){

            case 1: case 21: case 31: case 41: case 51:
                return "хвилина";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
            case 32: case 33: case 34:
            case 42: case 43: case 44:
            case 52: case 53: case 54:
                return "хвилини";

            default: return "хвилин";
        }
    }

    @Override
    public String hours(int hours){
        switch (hours){

            case 1: case 21:
                return "година";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
                return "години";

            default: return "годин";
        }
    }

    @Override
    public String days(int days){
        switch (days){

            case 1: case 21: case 31:
                return "день";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
                return "дні";

            default: return "днів";
        }
    }

    @Override
    public String months(int months){
        switch (months){

            case 1:
                return "місяць";

            case 2: case 3: case 4:
                return "місяці";

            default: return "місяців";
        }
    }

    @Override
    public String years(int years){
        switch (years){

            case 1: case 21: case 31: case 41: case 51:
                return "рік";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
            case 32: case 33: case 34:
            case 42: case 43: case 44:
            case 52: case 53: case 54:
                return "роки";

            default: return "років";
        }
    }


}
