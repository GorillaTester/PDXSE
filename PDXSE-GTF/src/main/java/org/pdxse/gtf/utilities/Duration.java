package org.pdxse.gtf.utilities;

import org.apache.log4j.Logger;

@SuppressWarnings("unused")
public class Duration
{

    private static final Logger logger = Logger.getLogger(Duration.class);

    private double startTime;
    private double endTime;

    public Duration()
    {
        super();
        startTime = 0;
        endTime = 0;
    }

    /**
     *Starts the Duration clock
     */
    public void startClock()
    {
        startTime = System.currentTimeMillis();
    }

    /**
     *Stops the Duration clock
     */
    public void stopClock()
    {
        endTime = System.currentTimeMillis();
    }

    /**
     * Calculates and returns the calculated Duration in milliseconds as a long
     *
     * @return Duration milliseconds as a long value
     */
    public long calculateDurationInMilliseconds()
    {
        long lEndTime = (long) endTime;
        long lStartTime = (long) startTime;
        return lEndTime - lStartTime;
    }

    /**
     * Calculates and returns the calculated Duration in milliseconds as a formatted String
     *
     * @return Duration milliseconds as a formatted String
     */
    public String getCalculatedDurationInMilliseconds()
    {

        long lEndTime = (long) endTime;
        long lStartTime = (long) startTime;
        long duration = lEndTime - lStartTime;

        String milliseconds = new String();
        milliseconds = String.valueOf(duration) + " milliseconds";
        return milliseconds;
    }

    /**
     * Calculates and returns the calculated Duration in hours, minutes, second and milliseconds as a formatted String
     *
     * @return  Duration hours, minutes, second and milliseconds as a formatted String
     */
    public String getCalculatedDuration()
    {

        String durationString = new String();

        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        double milliseconds = 0;

        if ((endTime - startTime) > 0)
        {
            double duration = endTime - startTime;

            if (duration >= 3600000)
            {
                hours = (int) duration / 3600000;
                duration = duration - (hours * 3600000);
                if (hours == 1)
                {
                    durationString = durationString + hours + " hour";
                }
                else
                {
                    durationString = durationString + hours + " hours";
                }

                if (duration > 0)
                {
                    durationString = durationString + " ";
                }
            }
            if (duration >= 60000)
            {
                minutes = (int) duration / 60000;
                duration = duration - (minutes * 60000);
                if (minutes == 1)
                {
                    durationString = durationString + minutes + " minute";
                }
                else
                {
                    durationString = durationString + minutes + " minutes";
                }
                if (duration > 0)
                {
                    durationString = durationString + " ";
                }
            }
            if (duration >= 1000)
            {
                seconds = (int) duration / 1000;
                duration = duration - (seconds * 1000);
                if (seconds == 1)
                {
                    durationString = durationString + seconds + " second";
                }
                else
                {
                    durationString = durationString + seconds + " seconds";
                }
                if (duration > 0)
                {
                    durationString = durationString + " ";
                }
            }
            if (duration > 0)
            {
                milliseconds = duration;
                if (milliseconds == 1)
                {
                    durationString = durationString + milliseconds + " milisecond";
                }
                else
                {
                    durationString = durationString + milliseconds + " milliseconds";
                }

            }

        }
        else
        {
            durationString = "0 milliseconds or less";
        }

        return durationString;
    }

    /**
     * Returns the Duration start time
     *
     * @return Duration start time
     */
    public double getStartTime()
    {
        return startTime;
    }

    /**
     *Sets the Duration start time
     *
     * @param startTime Duration start time
     */
    public void setStartTime(double startTime)
    {
        this.startTime = startTime;
    }

    /**
     * Returns the Duration end time
     *
     * @return Duration end time
     */
    public double getEndTime()
    {
        return endTime;
    }

    /**
     * Sets the Duration end time
     *
     * @param endTime Duration end time
     */
    public void setEndTime(double endTime)
    {
        this.endTime = endTime;
    }
}
