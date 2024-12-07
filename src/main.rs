mod easy;
mod easy_tests;

fn main() {
    let res = crate::easy::remove_duplicates(&mut vec![0,0,0,0,1,1,1,1,2,2,3]);
    for i in (0..4).rev(){
        println!("{}",i);
    }
}
