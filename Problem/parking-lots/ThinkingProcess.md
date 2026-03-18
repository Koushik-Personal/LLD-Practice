--FLOW

1. Vehicle enter
2. generate Ticket from gate -> Giving ticket bashed on available slot and vehicle type
3. Vehicle parked
4. Vehicle leave
5. Cost calculated
6. Exit and free slot

--CLASS

1. vehicle {
      1. id
      2. numberPlate
      3. vehicleType
   }

2. ticket {
      1. id
      2. vehicleId
      3. slotId
   }

3. slot {
      1. id
      2. slotType
      3. cost
    }

4. Receipt {
      1. Id
      2. ticketId
      3. hours
      4. amount
    }

5. Floor {
      1. id
      2. List<slot>
     }

--ENUMS

1. vehicleType {
      1. BIKE
      2. CAR
      3. TRUCK
   }

2. slotType {
      1. SMALL
      2. MEDIUM
      3. BIG
}
