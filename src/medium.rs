use std::cmp::Reverse;
use std::collections::BinaryHeap;

pub fn string_sequence(target: String) -> Vec<String> {
    let mut result = Vec::new();
    let mut screen = String::new();
    for c in target.chars() {
        screen.push('a');
        result.push(screen.clone());
        let mut j = 'a';
        while j != c {
            j = (j as u8 + 1) as char;
            screen.pop();
            screen.push(j);
            result.push(screen.clone());
        }
    }
    result
}

pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    let mut pq: BinaryHeap<Reverse<(i32, Vec<i32>)>> = BinaryHeap::new();
    let k = k as usize;
    for point in points {
        let distance = point[0] * point[0] + point[1] * point[1];
        pq.push(Reverse((distance, point.clone())));
        if pq.len() > k {
            pq.pop();
        }
    }

    let mut res = Vec::with_capacity(k);
    while let Some(Reverse((_, point))) = pq.pop() {
        res.push(point);
    }
    res
}


#[cfg(test)]
mod tests {
    use super::*;


    #[test]
    fn test_string_sequence() {
        assert_eq!(string_sequence("abc".to_string()), ["aaa", "aa"]);
    }
}
