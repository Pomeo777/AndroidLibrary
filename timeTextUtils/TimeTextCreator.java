package ua.redTeam.peopleForPeople.utils.timeTextUtils;


import android.content.Context;

import java.util.Locale;

import ua.redTeam.peopleForPeople.R;
import ua.redTeam.peopleForPeople.utils.timeTextUtils.elapsedTime.LocaleInflexionCreator;
import ua.redTeam.peopleForPeople.utils.timeTextUtils.elapsedTime.RUTimeInflexionCreatorImpl;
import ua.redTeam.peopleForPeople.utils.timeTextUtils.elapsedTime.UATimeInflexionCreatorImpl;
import ua.redTeam.peopleForPeople.utils.timeTextUtils.remainingTime.LocaleRemainingTimeCreator;
import ua.redTeam.peopleForPeople.utils.timeTextUtils.remainingTime.RURemainingTimeCreatorimpl;
import ua.redTeam.peopleForPeople.utils.timeTextUtils.remainingTime.UARemainingTimeCreatorimpl;


public class TimeTextCreator {

    public static final String TAG = "TimeTextCreator";

    private final Context context;

    public TimeTextCreator(Context context) {
        this.context = context;
    }

    private final String YEARS = "years";
    private final String MONTHS = "months";
    private final String DAYS = "days";
    private final String HOURS = "hours";
    private final String MINUTES = "minutes";
    private final String SECONDS = "seconds";


    public String elapsedTimeText(String key, long value){

        LocaleInflexionCreator creator = LocaleInflexionCreatorFactory.getInflexionCreator(Locale.getDefault().getLanguage());

        switch (key){
            case YEARS:
                return String.format("%s %s %s", value, creator.years((int) value), context.getString(R.string.ago));

            case MONTHS:
                return String.format("%s %s %s", value, creator.months((int) value), context.getString(R.string.ago));

            case DAYS:
                return String.format("%s %s %s", value, creator.days((int) value), context.getString(R.string.ago));

            case HOURS:
                return String.format("%s %s %s", value, creator.hours((int) value), context.getString(R.string.ago));

            case MINUTES:
                return String.format("%s %s %s", value, creator.minutes((int) value), context.getString(R.string.ago));

            case SECONDS:
                return String.format("%s %s %s", value, creator.seconds((int) value), context.getString(R.string.ago));

            default: return null;
        }

    }

    public  String timeText(String key, long value){

        LocaleInflexionCreator creator = LocaleInflexionCreatorFactory.getInflexionCreator(Locale.getDefault().getLanguage());

        switch (key){
            case YEARS:
                return String.format("%s %s", value, creator.years((int) value));

            case MONTHS:
                return String.format("%s %s", value, creator.months((int) value));

            case DAYS:
                return String.format("%s %s", value, creator.days((int) value));

            case HOURS:
                return String.format("%s %s", value, creator.hours((int) value));

            case MINUTES:
                return String.format("%s %s", value, creator.minutes((int) value));

            case SECONDS:
                return String.format("%s %s", value, creator.seconds((int) value));

            default: return null;
        }

    }

    public  String remainingTimeText(String key, long value){

        LocaleRemainingTimeCreator creator = LocaleRemainingTimeCreatorFactory.getRemainingCreator(Locale.getDefault().getLanguage());

        switch (key){
            case YEARS:
                return String.format("%s %s", value, creator.years((int) value));

            case MONTHS:
                return String.format("%s %s", value, creator.months((int) value));

            case DAYS:
                return String.format("%s %s", value, creator.days((int) value));

            case HOURS:
                return String.format("%s %s", value, creator.hours((int) value));

            case MINUTES:
                return String.format("%s %s", value, creator.minutes((int) value));

            case SECONDS:
                return String.format("%s %s", value, creator.seconds((int) value));

            default: return null;
        }

    }


    private static class LocaleInflexionCreatorFactory{

         static LocaleInflexionCreator getInflexionCreator(String locale){

             if ("ru".equals(locale)) {
                 return new RUTimeInflexionCreatorImpl();
             }
             return new UATimeInflexionCreatorImpl();


         }


    }

    private static class LocaleRemainingTimeCreatorFactory{

        static LocaleRemainingTimeCreator getRemainingCreator(String locale){

            if ("ru".equals(locale)) {
                return new RURemainingTimeCreatorimpl();
            }
            return new UARemainingTimeCreatorimpl();


        }


    }




}
