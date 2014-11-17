/**
 * Copyright (c) 2014 The Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */


package edu.berkeley.path.model_objects.scenario;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class RampMeterTest {

    private static final int RMSE_ID = 1;

    private static final int RMS_ID = 2;
    private static final String RMS_NAME = "RMS Name";

    private static final int RMLV_ID = 3;
    private static final int RMLV_TYPE_ID = 4;
    private static final int RMLV_PLAN_ID = 5;

    private static final int RMRV_ID = 6;
    private static final int RMRV_TYPE_ID = 7;
    private static final int RMRV_PLAN_ID = 8;
    private static final String RMRV_VALUE = "RMRM value";

    private static final int RMRT_ID = 9;
    private static final String RMRT_NAME = "RMRT Name";
    private static final String RMRT_DESC = "RMRT Desc";

    private static final int RMLT_ID = 10;
    private static final String RMLT_NAME = "RMLT Name";
    private static final String RMLT_DESC = "RMLT Desc";

    private static final int RMH_ID = 11;
    private static final int RMH_PLAN_ID = 12;
    private static final String RMH_NAME = "RMH Name";
    private static final int RMH_MONTH = 13;
    private static final int RMH_DAY = 14;

    private static final int RMP_ID = 15;
    private static final String RMP_NAME = "RMP Name";
    private static final String RMP_DESC = "RMP Description";

    private static final int CNTRL_ID = 16;

    private static final String MOD_STAMP = "18-JAN-2008 02:51:00";

    private edu.berkeley.path.model_objects.scenario.RampMeterScheduleElement rampMeterScheduleElement;
    private edu.berkeley.path.model_objects.scenario.RampMeterSchedule rampMeterSchedule;
    private edu.berkeley.path.model_objects.scenario.RampMeterLsdValue rampMeterLsdValue;
    private edu.berkeley.path.model_objects.scenario.RampMeterRamValue rampMeterRamValue;
    private edu.berkeley.path.model_objects.scenario.RampMeterHoliday  rampMeterHoliday;
    private edu.berkeley.path.model_objects.scenario.RampMeterPlan  rampMeterPlan;
    private edu.berkeley.path.model_objects.scenario.RampMeterRamType rampMeterRamType;
    private edu.berkeley.path.model_objects.scenario.RampMeterLsdType  rampMeterLsdType;

    @Before
    public void setUp() {

        //RampMeterScheduleElement
        rampMeterScheduleElement = new RampMeterScheduleElement();
        rampMeterScheduleElement.setMonday(true);
        rampMeterScheduleElement.setWednesday(true);
        rampMeterScheduleElement.setFriday(true);
        rampMeterScheduleElement.setId(RMSE_ID);
        rampMeterScheduleElement.setModStamp(MOD_STAMP);

        //RampMeterSchedule
        List<RampMeterScheduleElement> rampMeterScheduleElementList = new ArrayList<RampMeterScheduleElement>();
        rampMeterScheduleElementList.add(rampMeterScheduleElement);
        rampMeterSchedule = new RampMeterSchedule();
        rampMeterSchedule.setModStamp(MOD_STAMP);
        rampMeterSchedule.setId(RMS_ID);
        rampMeterSchedule.setName(RMS_NAME);
        rampMeterSchedule.setListOfRampMeterScheduleElement(rampMeterScheduleElementList);

        //RampMeterLsdValue
        rampMeterLsdValue = new RampMeterLsdValue();
        rampMeterLsdValue.setId(RMLV_ID);
        rampMeterLsdValue.setTypeId(RMLV_TYPE_ID);
        rampMeterLsdValue.setPlanId(RMLV_PLAN_ID);
        rampMeterLsdValue.setValue(true);

        //RampMeterLsdType
        rampMeterLsdType = new RampMeterLsdType();
        rampMeterLsdType.setId(RMLT_ID);
        rampMeterLsdType.setName(RMLT_NAME);
        rampMeterLsdType.setDescription(RMLT_DESC);
        rampMeterLsdType.setInUse(1);
        rampMeterLsdType.setModStamp(MOD_STAMP);

        //RampMeterRamValue
        rampMeterRamValue = new RampMeterRamValue();
        rampMeterRamValue.setId(RMRV_ID);
        rampMeterRamValue.setTypeId(RMRV_TYPE_ID);
        rampMeterRamValue.setPlanId(RMRV_PLAN_ID);
        rampMeterRamValue.setValue(RMRV_VALUE);

        //RampMeterRamType
        rampMeterRamType = new RampMeterRamType();
        rampMeterRamType.setId(RMRT_ID);
        rampMeterRamType.setName(RMRT_NAME);
        rampMeterRamType.setDescription(RMRT_DESC);
        rampMeterRamType.setInUse(1);
        rampMeterRamType.setModStamp(MOD_STAMP);

        //RampMeterHoliday
        rampMeterHoliday = new RampMeterHoliday();
        rampMeterHoliday.setId(RMH_ID);
        rampMeterHoliday.setPlanId(RMH_PLAN_ID);
        rampMeterHoliday.setName(RMH_NAME);
        rampMeterHoliday.setModStamp(MOD_STAMP);
        rampMeterHoliday.setMonth(RMH_MONTH);
        rampMeterHoliday.setDay(RMH_DAY);

        //RampMeterPlan
        rampMeterPlan = new RampMeterPlan();
        rampMeterPlan.setId(RMP_ID);
        rampMeterPlan.setControllerId(CNTRL_ID);
        rampMeterPlan.setName(RMP_NAME);
        rampMeterPlan.setDescription(RMP_DESC);

        List<RampMeterHoliday> rampMeterHolidayList = new ArrayList<RampMeterHoliday>();
        rampMeterHolidayList.add(rampMeterHoliday);
        rampMeterPlan.setListOfRampMeterHoliday(rampMeterHolidayList);

        List<RampMeterRamValue> rampMeterRamValueList = new ArrayList<RampMeterRamValue>();
        rampMeterRamValueList.add(rampMeterRamValue);
        rampMeterPlan.setListOfRampMeterRamValue(rampMeterRamValueList);

        List<RampMeterLsdValue> rampMeterLsdValueList = new ArrayList<RampMeterLsdValue>();
        rampMeterLsdValueList.add(rampMeterLsdValue);
        rampMeterPlan.setListOfRampMeterLsdValue(rampMeterLsdValueList);

        List<RampMeterSchedule> rampMeterScheduleList = new ArrayList<RampMeterSchedule>();
        rampMeterScheduleList.add(rampMeterSchedule);
        rampMeterPlan.setListOfRampMeterSchedule(rampMeterScheduleList);
    }

    @Test
    public void testObjects() {

        //RampMeterScheduleElement
        assertEquals(true,rampMeterScheduleElement.isMonday());
        assertEquals(true, rampMeterScheduleElement.isWednesday());
        assertEquals(RMSE_ID, rampMeterScheduleElement.getId());
        assertEquals(MOD_STAMP, rampMeterScheduleElement.getModStamp());

        //RampMeterSchedule
        assertEquals(RMS_ID, rampMeterSchedule.getId());
        assertEquals(1,rampMeterSchedule.getListOfRampMeterScheduleElement().size());
        assertEquals(RMS_NAME,rampMeterSchedule.getName());
        assertEquals(MOD_STAMP, rampMeterSchedule.getModStamp());

        //RampMeterLsdValue
        assertEquals(RMLV_ID, rampMeterLsdValue.getId());
        assertEquals(RMLV_TYPE_ID, rampMeterLsdValue.getTypeId());
        assertEquals(RMLV_PLAN_ID, rampMeterLsdValue.getPlanId());
        assertEquals(true, rampMeterLsdValue.isValue());

        //RampMeterLsdType
        assertEquals(RMLT_ID, rampMeterLsdType.getId());
        assertEquals(RMLT_NAME, rampMeterLsdType.getName());
        assertEquals(RMLT_DESC, rampMeterLsdType.getDescription());
        assertEquals(1, rampMeterLsdType.getInUse().intValue());
        assertEquals(MOD_STAMP, rampMeterLsdType.getModStamp());

        //RampMeterRamValue
        assertEquals(RMRV_ID, rampMeterRamValue.getId());
        assertEquals(RMRV_TYPE_ID, rampMeterRamValue.getTypeId());
        assertEquals(RMRV_PLAN_ID, rampMeterRamValue.getPlanId());
        assertEquals(RMRV_VALUE, rampMeterRamValue.getValue());

        //RampMeterRamType
        assertEquals(RMRT_ID, rampMeterRamType.getId());
        assertEquals(RMRT_NAME, rampMeterRamType.getName());
        assertEquals(RMRT_DESC, rampMeterRamType.getDescription());
        assertEquals(1, rampMeterRamType.getInUse().intValue());
        assertEquals(MOD_STAMP, rampMeterRamType.getModStamp());

        //RampMeterHoliday
        assertEquals(RMH_ID, rampMeterHoliday.getId());
        assertEquals(RMH_PLAN_ID, rampMeterHoliday.getPlanId());
        assertEquals(RMH_NAME, rampMeterHoliday.getName());
        assertEquals(RMH_MONTH, rampMeterHoliday.getMonth());
        assertEquals(RMH_DAY, rampMeterHoliday.getDay());

        //RampMeterPlan
        assertEquals(RMP_ID, rampMeterPlan.getId());
        assertEquals(CNTRL_ID, rampMeterPlan.getControllerId());
        assertEquals(RMP_NAME,rampMeterPlan.getName());
        assertEquals(RMP_DESC,rampMeterPlan.getDescription());
        assertEquals(1,rampMeterPlan.getListOfRampMeterLsdValue().size());
        assertEquals(1,rampMeterPlan.getListOfRampMeterHoliday().size());
        assertEquals(1,rampMeterPlan.getListOfRampMeterRamValue().size());
        assertEquals(1,rampMeterPlan.getListOfRampMeterSchedule().size());

    }

}
