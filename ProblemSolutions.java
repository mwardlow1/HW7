/*
         * A temporary array is used to store the merged results
         * Two pointers are used for the subarrays
         */
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;

        /*
         * Check whether the element from the left and right side is divisible by k
         * If both are divisible by k, the left is added first
         * Else if only the left sided element is divisible, the left element is added
         * Else if only the right sided element is divisible, the right element is added
         * Otherwise the loop breaks
         */
        while (i <= mid && j <= right) {
            boolean iDivisible = arr[i] % k == 0;
            boolean jDivisble = arr[j] % k == 0;

            if (iDivisible && jDivisble) {
                temp[index++] = arr[i++];
            } else if (iDivisible) {
                temp[index++] = arr[i++];
            } else if (jDivisble) {
                temp[index++] = arr[j++];
            } else {
                break; 
            }
        }

        // The remaining divisible elements from the left are added
        while (i <= mid && arr[i] % k == 0) {
            temp[index++] = arr[i++];
        }

        // The remaining divisible elements from the right are added
        while (j <= right && arr[j] % k == 0) {
            temp[index++] = arr[j++];
        }

        // The non-divisible numbers are merged together
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        /**
         * The remaining non-divisible elements from the left and right side are added
         */
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }

        // The new array is restored with contents of the temporary array
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
        return;
